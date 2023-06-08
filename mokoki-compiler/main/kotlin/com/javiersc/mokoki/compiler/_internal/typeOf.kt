package com.javiersc.mokoki.compiler._internal

import com.javiersc.kotlin.compiler.extensions.ir.findIrFunction
import com.javiersc.kotlin.compiler.extensions.ir.toCallableId
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrFunction

internal val IrPluginContext.typeOfIrFunction: IrFunction?
    get() = findIrFunction("kotlin.reflect.typeOf".toCallableId())
