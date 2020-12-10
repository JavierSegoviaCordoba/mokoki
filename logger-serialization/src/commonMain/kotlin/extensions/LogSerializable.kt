package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.core.extensions.logC
import com.javiersc.logger.core.extensions.logD
import com.javiersc.logger.core.extensions.logE
import com.javiersc.logger.core.extensions.logI
import com.javiersc.logger.core.extensions.logV
import com.javiersc.logger.core.extensions.logW
import com.javiersc.logger.serialization.internal.json
import kotlinx.serialization.KSerializer

public fun <T> logSerializableV(tag: String, serializer: KSerializer<T>, message: T): Unit =
    logV(tag, json.encodeToString(serializer, message))

public fun <T> logSerializableD(tag: String, serializer: KSerializer<T>, message: T): Unit =
    logD(tag, json.encodeToString(serializer, message))

public fun <T> logSerializableI(tag: String, serializer: KSerializer<T>, message: T): Unit =
    logI(tag, json.encodeToString(serializer, message))

public fun <T> logSerializableW(tag: String, serializer: KSerializer<T>, message: T): Unit =
    logW(tag, json.encodeToString(serializer, message))

public fun <T> logSerializableE(tag: String, serializer: KSerializer<T>, message: T): Unit =
    logE(tag, json.encodeToString(serializer, message))

public fun <T> logSerializableC(
    tag: String,
    serializer: KSerializer<T>,
    message: T,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = logC(tag, json.encodeToString(serializer, message), backgroundColor, foregroundColor)
