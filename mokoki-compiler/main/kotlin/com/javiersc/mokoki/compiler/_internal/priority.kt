package com.javiersc.mokoki.compiler._internal

import com.javiersc.kotlin.compiler.extensions.common.classId
import com.javiersc.kotlin.compiler.extensions.ir.enumEntry
import com.javiersc.kotlin.compiler.extensions.ir.name
import com.javiersc.kotlin.compiler.extensions.ir.toIrGetEnumValue
import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.Priority.ASSERT
import com.javiersc.mokoki.Priority.DEBUG
import com.javiersc.mokoki.Priority.ERROR
import com.javiersc.mokoki.Priority.INFO
import com.javiersc.mokoki.Priority.VERBOSE
import com.javiersc.mokoki.Priority.WARN
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.util.defaultType

internal val IrPluginContext.priorityClass: IrClass?
    get() = referenceClass(classId<Priority>())?.owner

internal fun IrClass.priorityIrExpression(priority: Priority): IrExpression? =
    enumEntry(priority)?.let { defaultType.toIrGetEnumValue(it) }

internal fun IrClass.priorityIrExpression(logCall: IrCall): IrExpression =
    when {
        "${logCall.name}" == LogV -> priorityIrExpression(VERBOSE)
        "${logCall.name}" == LogD -> priorityIrExpression(DEBUG)
        "${logCall.name}" == LogI -> priorityIrExpression(INFO)
        "${logCall.name}" == LogW -> priorityIrExpression(WARN)
        "${logCall.name}" == LogE -> priorityIrExpression(ERROR)
        "${logCall.name}" == LogWTF -> priorityIrExpression(ASSERT)
        else -> priorityIrExpression(VERBOSE)
    } ?: error("A default `Priority` must appear before this")
