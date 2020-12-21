package com.javiersc.logger

public expect class Logger internal constructor() {

    public var mode: Mode
    public var isEnabled: Boolean

    public fun v(tag: String?, message: Any)
    public fun d(tag: String?, message: Any)
    public fun i(tag: String?, message: Any)
    public fun w(tag: String?, message: Any)
    public fun e(tag: String?, message: Any)
    public fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    )
}
