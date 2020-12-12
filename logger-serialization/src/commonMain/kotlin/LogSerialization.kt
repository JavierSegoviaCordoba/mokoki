@file:Suppress("TooManyFunctions")

package com.javiersc.logger.serialization

import com.javiersc.logger.core.Log
import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.core.Mode
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

    public fun v(tag: String? = null, message: Any): Unit = logger.v(tag, message)

    public fun jsonV(tag: String? = null, message: String): Unit = logger.vJson(tag, message)

    public fun <T> serializableV(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.vSerializable(tag, serializer, message)

    public fun d(tag: String? = null, message: Any): Unit = logger.d(tag, message)

    public fun jsonD(tag: String? = null, message: String): Unit = logger.dJson(tag, message)

    public fun <T> serializableD(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.dSerializable(tag, serializer, message)

    public fun i(tag: String? = null, message: Any): Unit = logger.i(tag, message)

    public fun jsonI(tag: String? = null, message: String): Unit = logger.iJson(tag, message)

    public fun <T> serializableI(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.iSerializable(tag, serializer, message)

    public fun w(tag: String? = null, message: Any): Unit = logger.w(tag, message)

    public fun jsonW(tag: String? = null, message: String): Unit = logger.wJson(tag, message)

    public fun <T> serializableW(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.wSerializable(tag, serializer, message)

    public fun e(tag: String? = null, message: Any): Unit = logger.e(tag, message)

    public fun jsonE(tag: String? = null, message: String): Unit = logger.eJson(tag, message)

    public fun <T> serializableE(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.eSerializable(tag, serializer, message)

    public fun c(
        tag: String? = null,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, message, backgroundColor, foregroundColor)

    public fun jsonC(
        tag: String? = null,
        message: String,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.cJson(tag, message, backgroundColor, foregroundColor)

    public fun <T> serializableC(
        tag: String,
        serializer: KSerializer<T>,
        message: T,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.cSerializable(tag, serializer, message, backgroundColor, foregroundColor)
}
