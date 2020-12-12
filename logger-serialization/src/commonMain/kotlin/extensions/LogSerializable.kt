package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.serialization.LogSerialization
import kotlinx.serialization.KSerializer

public fun <T> logSerializableV(tag: String, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableV(tag, serializer, message)

public fun <T> logSerializableD(tag: String, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableD(tag, serializer, message)

public fun <T> logSerializableI(tag: String, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableI(tag, serializer, message)

public fun <T> logSerializableW(tag: String, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableW(tag, serializer, message)

public fun <T> logSerializableE(tag: String, serializer: KSerializer<T>, message: T): Unit =
    LogSerialization.serializableE(tag, serializer, message)

public fun <T> logSerializableC(
    tag: String,
    serializer: KSerializer<T>,
    message: T,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = LogSerialization.serializableC(tag, serializer, message, backgroundColor, foregroundColor)
