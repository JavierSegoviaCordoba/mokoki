package com.javiersc.mokoki.compiler

import com.javiersc.kotlin.compiler.extensions.common.toCallableId
import com.javiersc.kotlin.compiler.extensions.ir.IrTreeNode
import com.javiersc.kotlin.compiler.extensions.ir.asIrOrNull
import com.javiersc.kotlin.compiler.extensions.ir.exhaustiveKind
import com.javiersc.kotlin.compiler.extensions.ir.firstIrOrNull
import com.javiersc.kotlin.compiler.extensions.ir.hasAnnotation
import com.javiersc.kotlin.compiler.extensions.ir.irFile
import com.javiersc.kotlin.compiler.extensions.ir.lineNumber
import com.javiersc.kotlin.compiler.extensions.ir.name
import com.javiersc.kotlin.compiler.extensions.ir.parentIrClass
import com.javiersc.kotlin.compiler.extensions.ir.parentIrFunction
import com.javiersc.kotlin.compiler.extensions.ir.toIrCall
import com.javiersc.kotlin.compiler.extensions.ir.treeNode
import com.javiersc.kotlin.stdlib.tree.TreeNode
import com.javiersc.mokoki.Mokoki
import com.javiersc.mokoki.compiler._internal.ClassExhaustiveKind
import com.javiersc.mokoki.compiler._internal.ClassName
import com.javiersc.mokoki.compiler._internal.FileLink
import com.javiersc.mokoki.compiler._internal.FileName
import com.javiersc.mokoki.compiler._internal.FunctionName
import com.javiersc.mokoki.compiler._internal.KType
import com.javiersc.mokoki.compiler._internal.LineNumber
import com.javiersc.mokoki.compiler._internal.Log
import com.javiersc.mokoki.compiler._internal.LogPriority
import com.javiersc.mokoki.compiler._internal.Message
import com.javiersc.mokoki.compiler._internal.Priority
import com.javiersc.mokoki.compiler._internal.Tag
import com.javiersc.mokoki.compiler._internal.priorityClass
import com.javiersc.mokoki.compiler._internal.priorityIrExpression
import com.javiersc.mokoki.compiler._internal.typeOfIrFunction
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.backend.js.utils.typeArguments
import org.jetbrains.kotlin.ir.backend.js.utils.valueArguments
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.declarations.IrValueParameter
import org.jetbrains.kotlin.ir.declarations.name
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrStatementContainer
import org.jetbrains.kotlin.ir.types.IrType
import org.jetbrains.kotlin.ir.util.toIrConst

public class IrMokokiExtension : IrGenerationExtension {

    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        pluginContext.build(moduleFragment)
    }
}

private val IrFile.logCallsNodes: List<IrTreeNode>
    get() = treeNode.filter { it.value.asIrOrNull<IrCall>()?.hasAnnotation<Mokoki>() ?: false }

private val IrPluginContext.internalLogIrFunction: IrSimpleFunction?
    get() =
        referenceFunctions("com.javiersc.mokoki._internal.internalLog".toCallableId())
            .firstOrNull()
            ?.owner
            ?.asIrOrNull()

private fun IrPluginContext.build(moduleFragment: IrModuleFragment) {
    val irFileTreeNodes: List<IrTreeNode> = moduleFragment.files.flatMap(IrFile::treeNode)
    val internalLogIrFunction: IrSimpleFunction = internalLogIrFunction ?: return
    val priorityIrClass: IrClass = priorityClass ?: return
    val typeOfIrFunction: IrSimpleFunction = typeOfIrFunction.asIrOrNull() ?: return

    for (irFileTreeNode: IrTreeNode in irFileTreeNodes) {
        val logCallsNodes = irFileTreeNode.firstIrOrNull<IrFile>()?.logCallsNodes ?: continue
        processLogCallsNodes(
            logCallsNodes = logCallsNodes,
            internalLogIrFunction = internalLogIrFunction,
            priorityIrClass = priorityIrClass,
            typeOfIrFunction = typeOfIrFunction,
        )
    }
}

private fun IrPluginContext.processLogCallsNodes(
    logCallsNodes: List<IrTreeNode>,
    internalLogIrFunction: IrSimpleFunction,
    priorityIrClass: IrClass,
    typeOfIrFunction: IrSimpleFunction,
) {
    for (logCallNode: TreeNode<IrElement> in logCallsNodes) {
        val internalLogCall: IrCall = internalLogIrFunction.toIrCall()
        val logCall: IrCall = logCallNode.value.asIrOrNull() ?: return
        val irStatementContainer: IrStatementContainer =
            logCallNode.parent?.value?.asIrOrNull() ?: continue

        putValueParametersOnInternalLogCall(
            internalLogCall = internalLogCall,
            internalLog = internalLogIrFunction,
            logCallNode = logCallNode,
            logCall = logCall,
            priorityIrClass = priorityIrClass,
            typeOfIrFunction = typeOfIrFunction,
        )

        irStatementContainer.statements.replaceAll { statement ->
            if (statement != logCall) statement else internalLogCall
        }
    }
}

private fun IrPluginContext.putValueParametersOnInternalLogCall(
    internalLogCall: IrCall,
    internalLog: IrFunction,
    logCallNode: TreeNode<IrElement>,
    logCall: IrCall,
    priorityIrClass: IrClass,
    typeOfIrFunction: IrSimpleFunction,
) {
    for ((index, internalLogValueParameter) in internalLog.valueParameters.withIndex()) {
        val irExpression: IrExpression? =
            buildIrExpressionBasedOnValueParameter(
                internalLogValueParameter = internalLogValueParameter,
                logCallNode = logCallNode,
                logCall = logCall,
                priorityIrClass = priorityIrClass,
                typeOfIrFunction = typeOfIrFunction,
            )
        internalLogCall.putValueArgument(index, irExpression)
    }
}

private fun IrPluginContext.buildIrExpressionBasedOnValueParameter(
    internalLogValueParameter: IrValueParameter,
    logCallNode: TreeNode<IrElement>,
    logCall: IrCall,
    priorityIrClass: IrClass,
    typeOfIrFunction: IrSimpleFunction,
): IrExpression? {
    val logCallNameToIrExpression: Map<String, IrExpression?> =
        buildLogCallNameToIrExpression(logCall, priorityIrClass)

    val parentIrClass: IrClass? = logCallNode.parentIrClass

    val defaultMissingValue = "?"
    val kTypeIrType: IrType = logCall.typeArguments.firstOrNull() ?: irBuiltIns.anyType
    val kType: IrCall = typeOfIrFunction.toIrCall().apply { putTypeArgument(0, kTypeIrType) }
    val fileName: String = logCallNode.irFile?.name ?: defaultMissingValue
    val classExhaustiveKind = "${parentIrClass?.exhaustiveKind ?: "class"}"
    val className = "${parentIrClass?.name ?: defaultMissingValue}"
    val funName = "${logCallNode.parentIrFunction?.name ?: defaultMissingValue}"
    val lineNumber: Int = (logCallNode.lineNumber ?: 0)
    val fileLink = "($fileName:$lineNumber)"

    return when ("${internalLogValueParameter.name}") {
        KType -> kType
        Priority -> logCallNameToIrExpression[Priority]
        Tag -> logCallNameToIrExpression[Tag]
        FileLink -> fileLink.toIrConst(irBuiltIns.stringType)
        FileName -> fileName.toIrConst(irBuiltIns.stringType)
        ClassExhaustiveKind -> classExhaustiveKind.toIrConst(irBuiltIns.stringType)
        ClassName -> className.toIrConst(irBuiltIns.stringType)
        FunctionName -> funName.toIrConst(irBuiltIns.stringType)
        LineNumber -> lineNumber.toIrConst(irBuiltIns.intType)
        Message -> logCallNameToIrExpression[Message]
        else -> {
            error("`internalLog` value parameter not found for `${internalLogValueParameter.name}`")
        }
    }
}

private fun buildLogCallNameToIrExpression(
    logCall: IrCall,
    priorityIrClass: IrClass,
): Map<String, IrExpression?> = buildMap {
    val args: List<IrExpression?> = logCall.valueArguments

    for ((index: Int, irExpression: IrExpression?) in args.withIndex()) {
        val isLog = "${logCall.name}" == Log
        val isLogPriority = LogPriority.any { it == "${logCall.name}" }
        when {
            isLog -> {
                when (index) {
                    0 -> put(Priority, irExpression)
                    1 -> put(Tag, irExpression)
                    2 -> put(Message, irExpression)
                }
            }
            isLogPriority -> {
                val priorityIrExpression: IrExpression =
                    priorityIrClass.priorityIrExpression(logCall)
                if (!containsKey(Priority)) put(Priority, priorityIrExpression)
                when (index) {
                    0 -> put(Tag, irExpression)
                    1 -> put(Message, irExpression)
                }
            }
        }
    }
}
