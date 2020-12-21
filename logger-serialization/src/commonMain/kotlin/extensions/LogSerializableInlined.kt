package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor
import com.javiersc.logger.serialization.LogSerialization
import kotlinx.serialization.serializer

public inline fun <reified T> logSerializableV(tag: String? = null, message: T): Unit =
    LogSerialization.serializableV(tag, serializer(), message)

public inline fun <reified T> logSerializableD(tag: String? = null, message: T): Unit =
    LogSerialization.serializableD(tag, serializer(), message)

public inline fun <reified T> logSerializableI(tag: String? = null, message: T): Unit =
    LogSerialization.serializableI(tag, serializer(), message)

public inline fun <reified T> logSerializableW(tag: String? = null, message: T): Unit =
    LogSerialization.serializableW(tag, serializer(), message)

public inline fun <reified T> logSerializableE(tag: String? = null, message: T): Unit =
    LogSerialization.serializableE(tag, serializer(), message)

public inline fun <reified T> logSerializableC(
    tag: String? = null,
    message: T,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = LogSerialization.serializableC(tag, serializer(), message, backgroundColor, foregroundColor)
