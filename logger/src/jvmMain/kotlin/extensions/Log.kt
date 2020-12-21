@file:Suppress("TooManyFunctions")

package com.javiersc.logger.extensions

import com.javiersc.logger.Log
import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor

public actual fun logV(tag: String, message: Any): Unit = Log.v(tag, message)
public actual fun logV(message: Any): Unit = Log.v(null, message)

public actual fun logD(tag: String, message: Any): Unit = Log.d(tag, message)
public actual fun logD(message: Any): Unit = Log.d(null, message)

public actual fun logI(tag: String, message: Any): Unit = Log.i(tag, message)
public actual fun logI(message: Any): Unit = Log.i(null, message)

public actual fun logW(tag: String, message: Any): Unit = Log.w(tag, message)
public actual fun logW(message: Any): Unit = Log.w(null, message)

public actual fun logE(tag: String, message: Any): Unit = Log.e(tag, message)
public actual fun logE(message: Any): Unit = Log.e(null, message)

public actual fun logC(
    tag: String,
    message: Any,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = Log.c(tag, message, backgroundColor, foregroundColor)

public actual fun logC(
    message: Any,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor,
): Unit = Log.c(null, message, backgroundColor, foregroundColor)
