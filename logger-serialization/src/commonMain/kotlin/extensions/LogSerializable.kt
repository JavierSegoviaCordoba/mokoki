package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor
import com.javiersc.logger.serialization.LogSerialization
import kotlinx.serialization.KSerializer

public fun <T> logSerializableV(tag: String? = null, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableV(tag, serializer, message)

public fun <T> logSerializableD(tag: String? = null, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableD(tag, serializer, message)

public fun <T> logSerializableS(tag: String? = null, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableS(tag, serializer, message)

public fun <T> logSerializableI(tag: String? = null, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableI(tag, serializer, message)

public fun <T> logSerializableW(tag: String? = null, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableW(tag, serializer, message)

public fun <T> logSerializableE(tag: String? = null, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableE(tag, serializer, message)

public fun <T> logSerializableC(
    tag: String? = null,
    serializer: KSerializer<T>,
    message: T,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = LogSerialization.serializableC(tag, serializer, message, backgroundColor, foregroundColor)
