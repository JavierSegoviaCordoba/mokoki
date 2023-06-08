package com.javiersc.mokoki.compiler._internal

import com.javiersc.kotlin.compiler.extensions.common.toCallableId
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrFunction

internal val IrPluginContext.typeOfIrFunction: IrFunction?
    get() = referenceFunctions("kotlin.reflect.typeOf".toCallableId()).firstOrNull()?.owner
