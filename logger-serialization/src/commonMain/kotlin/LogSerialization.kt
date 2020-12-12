@file:Suppress("TooManyFunctions")

package com.javiersc.logger.serialization

import com.javiersc.logger.core.Log
import com.javiersc.logger.core.Logger
import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.core.Mode
import com.javiersc.logger.serialization.internal.json
import com.javiersc.logger.serialization.internal.prettyPrint
import kotlinx.serialization.KSerializer

public object LogSerialization {

    private val logger: Logger = Log.logger

    public var mode: Mode
        get() = logger.mode
        set(value) = with(logger) { mode = value }

    public var isEnabled: Boolean
        get() = logger.isEnabled
        set(value) = with(logger) { isEnabled = value }

    public fun v(tag: String? = null, message: Any): Unit = logger.v(tag, message)

    public fun jsonV(tag: String? = null, message: String): Unit = logger.v(tag, prettyPrint(message))

    public fun <T> serializableV(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.v(tag, json.encodeToString(serializer, message))

    public fun d(tag: String? = null, message: Any): Unit = logger.d(tag, message)

    public fun jsonD(tag: String? = null, message: String): Unit = logger.d(tag, prettyPrint(message))

    public fun <T> serializableD(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.d(tag, json.encodeToString(serializer, message))

    public fun i(tag: String? = null, message: Any): Unit = logger.i(tag, message)

    public fun jsonI(tag: String? = null, message: String): Unit = logger.i(tag, prettyPrint(message))

    public fun <T> serializableI(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.i(tag, json.encodeToString(serializer, message))

    public fun w(tag: String? = null, message: Any): Unit = logger.w(tag, message)

    public fun jsonW(tag: String? = null, message: String): Unit = logger.w(tag, prettyPrint(message))

    public fun <T> serializableW(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.w(tag, json.encodeToString(serializer, message))

    public fun de(tag: String? = null, message: Any): Unit = logger.e(tag, message)

    public fun jsonE(tag: String? = null, message: String): Unit = logger.e(tag, prettyPrint(message))

    public fun <T> serializableE(tag: String, serializer: KSerializer<T>, message: T): Unit =
        logger.e(tag, json.encodeToString(serializer, message))

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
    ): Unit = logger.c(tag, prettyPrint(message), backgroundColor, foregroundColor)

    public fun <T> serializableC(
        tag: String,
        serializer: KSerializer<T>,
        message: T,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, json.encodeToString(serializer, message), backgroundColor, foregroundColor)
}
