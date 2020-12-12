@file:Suppress("TooManyFunctions")

package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.serialization.LogSerialization

public fun logJsonV(tag: String, json: String): Unit = LogSerialization.jsonV(tag, json)
public fun logJsonV(json: String): Unit = LogSerialization.jsonV(null, json)

public fun logJsonD(tag: String, json: String): Unit = LogSerialization.jsonD(tag, json)
public fun logJsonD(json: String): Unit = LogSerialization.jsonD(null, json)

public fun logJsonI(tag: String, json: String): Unit = LogSerialization.jsonI(tag, json)
public fun logJsonI(json: String): Unit = LogSerialization.jsonI(null, json)

public fun logJsonW(tag: String, json: String): Unit = LogSerialization.jsonW(tag, json)
public fun logJsonW(json: String): Unit = LogSerialization.jsonW(null, json)

public fun logJsonE(tag: String, json: String): Unit = LogSerialization.jsonE(tag, json)
public fun logJsonE(json: String): Unit = LogSerialization.jsonE(null, json)

public fun logJsonC(
    tag: String,
    json: String,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = LogSerialization.jsonC(tag, json, backgroundColor, foregroundColor)

public fun logJsonC(
    json: String,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = LogSerialization.jsonC(null, json, backgroundColor, foregroundColor)
