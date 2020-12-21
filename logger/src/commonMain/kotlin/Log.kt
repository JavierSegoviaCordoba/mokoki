package com.javiersc.logger

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
public object Log {

    public val logger: Logger = Logger()

    public var mode: Mode
        get() = logger.mode
        set(value) = with(logger) { mode = value }

    public var isEnabled: Boolean
        get() = logger.isEnabled
        set(value) = with(logger) { isEnabled = value }

    public fun v(tag: String?, message: Any): Unit = logger.v(tag, message)

    public fun d(tag: String?, message: Any): Unit = logger.d(tag, message)

    public fun i(tag: String?, message: Any): Unit = logger.i(tag, message)

    public fun w(tag: String?, message: Any): Unit = logger.w(tag, message)

    public fun e(tag: String?, message: Any): Unit = logger.e(tag, message)

    public fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = logger.c(tag, message, backgroundColor, foregroundColor)
}
