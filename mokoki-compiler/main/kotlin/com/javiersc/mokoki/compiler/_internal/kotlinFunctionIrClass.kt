package com.javiersc.mokoki.compiler._internal

import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.types.IrTypeArgument
import org.jetbrains.kotlin.ir.types.impl.buildSimpleType
import org.jetbrains.kotlin.ir.types.impl.toBuilder
import org.jetbrains.kotlin.ir.util.defaultType

internal val IrPluginContext.kotlinFunction0StringIrClass: IrClass
    get() =
        irBuiltIns.functionN(0).apply {
            val stringType = irBuiltIns.stringType
            thisReceiver?.type =
                defaultType
                    .toBuilder()
                    .apply { arguments = listOf(stringType as IrTypeArgument) }
                    .buildSimpleType()
        }
