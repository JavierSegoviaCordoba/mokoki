@file:Suppress("TooManyFunctions")

package com.javiersc.logger.serialization

import com.javiersc.logger.Log
import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor
import com.javiersc.logger.Mode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
public object LogSerialization {

    public var serializersModule: SerializersModule = EmptySerializersModule
        set(value) {
            logger = LoggerSerialization(Log.logger, value)
        }

    private var logger: LoggerSerialization = LoggerSerialization(Log.logger, serializersModule)

    public var mode: Mode
        get() = logger.mode
        set(value) = with(logger) { mode = value }

    public var isEnabled: Boolean
        get() = logger.isEnabled
        set(value) = with(logger) { isEnabled = value }

    public fun v(tag: String?, message: Any): Unit = logger.v(tag, message)

    public fun jsonV(tag: String?, message: String): Unit = logger.jsonV(tag, message)

    public fun <T> serializableV(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.serializableV(tag, serializer, message)

    public fun d(tag: String?, message: Any): Unit = logger.d(tag, message)

    public fun jsonD(tag: String?, message: String): Unit = logger.jsonD(tag, message)

    public fun <T> serializableD(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.serializableD(tag, serializer, message)

    public fun s(tag: String?, message: Any): Unit = logger.s(tag, message)

    public fun jsonS(tag: String?, message: String): Unit = logger.jsonS(tag, message)

    public fun <T> serializableS(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.serializableS(tag, serializer, message)

    public fun i(tag: String?, message: Any): Unit = logger.i(tag, message)

    public fun jsonI(tag: String?, message: String): Unit = logger.jsonI(tag, message)

    public fun <T> serializableI(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.serializableI(tag, serializer, message)

    public fun w(tag: String?, message: Any): Unit = logger.w(tag, message)

    public fun jsonW(tag: String?, message: String): Unit = logger.jsonW(tag, message)

    public fun <T> serializableW(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.serializableW(tag, serializer, message)

    public fun e(tag: String?, message: Any): Unit = logger.e(tag, message)

    public fun jsonE(tag: String?, message: String): Unit = logger.jsonE(tag, message)

    public fun <T> serializableE(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.serializableE(tag, serializer, message)

    public fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, message, backgroundColor, foregroundColor)

    public fun jsonC(
        tag: String?,
        message: String,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.jsonC(tag, message, backgroundColor, foregroundColor)

    public fun <T> serializableC(
        tag: String?,
        serializer: KSerializer<T>,
        message: T,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.serializableC(tag, serializer, message, backgroundColor, foregroundColor)
}
