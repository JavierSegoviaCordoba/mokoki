@file:Suppress("TooManyFunctions")

package com.javiersc.logger.extensions

import com.javiersc.logger.Log
import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor

public fun logV(tag: String, message: Any): Unit = Log.v(tag, message)
public fun logV(message: Any): Unit = Log.v(null, message)

public fun logD(tag: String, message: Any): Unit = Log.d(tag, message)
public fun logD(message: Any): Unit = Log.d(null, message)

public fun logS(tag: String, message: Any): Unit = Log.s(tag, message)
public fun logS(message: Any): Unit = Log.s(null, message)

public fun logI(tag: String, message: Any): Unit = Log.i(tag, message)
public fun logI(message: Any): Unit = Log.i(null, message)

public fun logW(tag: String, message: Any): Unit = Log.w(tag, message)
public fun logW(message: Any): Unit = Log.w(null, message)

public fun logE(tag: String, message: Any): Unit = Log.e(tag, message)
public fun logE(message: Any): Unit = Log.e(null, message)

public fun logC(
    tag: String,
    message: Any,
    backgroundColor: LoggerBackgroundColor,
    foregroundColor: LoggerForegroundColor
): Unit = Log.c(tag, message, backgroundColor, foregroundColor)

public fun logC(message: Any, backgroundColor: LoggerBackgroundColor, foregroundColor: LoggerForegroundColor): Unit =
    Log.c(null, message, backgroundColor, foregroundColor)
