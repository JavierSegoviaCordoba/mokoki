@file:Suppress("TooManyFunctions")

package com.javiersc.logger.serialization

import com.javiersc.logger.core.Logger
import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.core.Mode
import com.javiersc.logger.serialization.internal.prettyPrint
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule

public class LoggerSerialization(
    private val logger: Logger,
    private val serializersModule: SerializersModule = EmptySerializersModule,
) {

    private val json: Json = Json {
        prettyPrint = true
        serializersModule = this@LoggerSerialization.serializersModule
    }

    public var mode: Mode
        get() = logger.mode
        set(value) = with(logger) { mode = value }

    public var isEnabled: Boolean
        get() = logger.isEnabled
        set(value) = with(logger) { isEnabled = value }

    public fun v(tag: String?, message: Any): Unit = logger.v(tag, message)

    public fun vJson(tag: String?, message: String): Unit = logger.v(tag, prettyPrint(json, tag, message))

    public fun <T> vSerializable(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.v(tag, prettyPrint(json, tag, serializer, message))

    public fun d(tag: String?, message: Any): Unit = logger.d(tag, message)

    public fun dJson(tag: String?, message: String): Unit = logger.d(tag, prettyPrint(json, tag, message))

    public fun <T> dSerializable(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.d(tag, prettyPrint(json, tag, serializer, message))

    public fun i(tag: String?, message: Any): Unit = logger.i(tag, message)

    public fun iJson(tag: String?, message: String): Unit = logger.i(tag, prettyPrint(json, tag, message))

    public fun <T> iSerializable(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.i(tag, prettyPrint(json, tag, serializer, message))

    public fun w(tag: String?, message: Any): Unit = logger.w(tag, message)

    public fun wJson(tag: String?, message: String): Unit = logger.w(tag, prettyPrint(json, tag, message))

    public fun <T> wSerializable(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.w(tag, prettyPrint(json, tag, serializer, message))

    public fun e(tag: String?, message: Any): Unit = logger.e(tag, message)

    public fun eJson(tag: String?, message: String): Unit = logger.e(tag, prettyPrint(json, tag, message))

    public fun <T> eSerializable(tag: String?, serializer: KSerializer<T>, message: T): Unit =
        logger.e(tag, prettyPrint(json, tag, serializer, message))

    public fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, message, backgroundColor, foregroundColor)

    public fun cJson(
        tag: String?,
        message: String,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, prettyPrint(json, tag, message), backgroundColor, foregroundColor)

    public fun <T> cSerializable(
        tag: String?,
        serializer: KSerializer<T>,
        message: T,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, prettyPrint(json, tag, serializer, message), backgroundColor, foregroundColor)
}
