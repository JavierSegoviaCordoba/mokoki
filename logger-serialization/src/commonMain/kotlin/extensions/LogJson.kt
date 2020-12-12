package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.serialization.LogSerialization
import com.javiersc.logger.serialization.internal.prettyPrint

public fun logJsonV(tag: String, json: String): Unit = LogSerialization.jsonV(tag, prettyPrint(json))

public fun logJsonD(tag: String, json: String): Unit = LogSerialization.jsonD(tag, prettyPrint(json))

public fun logJsonI(tag: String, json: String): Unit = LogSerialization.jsonI(tag, prettyPrint(json))

public fun logJsonW(tag: String, json: String): Unit = LogSerialization.jsonW(tag, prettyPrint(json))

public fun logJsonE(tag: String, json: String): Unit = LogSerialization.jsonE(tag, prettyPrint(json))

public fun logJsonC(
    tag: String,
    json: String,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = LogSerialization.jsonC(tag, prettyPrint(json), backgroundColor, foregroundColor)
