package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.core.extensions.logC
import com.javiersc.logger.core.extensions.logD
import com.javiersc.logger.core.extensions.logE
import com.javiersc.logger.core.extensions.logI
import com.javiersc.logger.core.extensions.logV
import com.javiersc.logger.core.extensions.logW
import com.javiersc.logger.serialization.internal.prettyPrint

public fun logJsonV(tag: String, json: String): Unit = logV(tag, prettyPrint(json))

public fun logJsonD(tag: String, json: String): Unit = logD(tag, prettyPrint(json))

public fun logJsonI(tag: String, json: String): Unit = logI(tag, prettyPrint(json))

public fun logJsonW(tag: String, json: String): Unit = logW(tag, prettyPrint(json))

public fun logJsonE(tag: String, json: String): Unit = logE(tag, prettyPrint(json))

public fun logJsonC(
    tag: String,
    json: String,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = logC(tag, prettyPrint(json), backgroundColor, foregroundColor)
