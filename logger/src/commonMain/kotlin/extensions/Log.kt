@file:Suppress("TooManyFunctions")

package com.javiersc.logger.extensions

import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor

public expect fun logV(tag: String, message: Any)
public expect fun logV(message: Any)

public expect fun logD(tag: String, message: Any)
public expect fun logD(message: Any)

public expect fun logI(tag: String, message: Any)
public expect fun logI(message: Any)

public expect fun logW(tag: String, message: Any)
public expect fun logW(message: Any)

public expect fun logE(tag: String, message: Any)
public expect fun logE(message: Any)

public expect fun logC(
    tag: String,
    message: Any,
    backgroundColor: LoggerBackgroundColor = LoggerBackgroundColor.Gray,
    foregroundColor: LoggerForegroundColor
)

public expect fun logC(
    message: Any,
    backgroundColor: LoggerBackgroundColor = LoggerBackgroundColor.Gray,
    foregroundColor: LoggerForegroundColor
)
