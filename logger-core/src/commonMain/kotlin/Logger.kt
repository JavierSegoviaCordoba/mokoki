package com.javiersc.logger.core

public expect class Logger internal constructor() {

    public var mode: Mode
    public var isEnabled: Boolean

    public fun v(tag: String? = null, message: Any)
    public fun d(tag: String? = null, message: Any)
    public fun i(tag: String? = null, message: Any)
    public fun w(tag: String? = null, message: Any)
    public fun e(tag: String? = null, message: Any)
    public fun c(
        tag: String? = null,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    )
}
