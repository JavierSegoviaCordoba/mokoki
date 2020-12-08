package com.javiersc.logger.core

import kotlin.native.concurrent.ThreadLocal

public interface Log {
    public fun v(tag: String? = null, message: Any)
    public fun d(tag: String? = null, message: Any)
    public fun i(tag: String? = null, message: Any)
    public fun w(tag: String? = null, message: Any)
    public fun e(tag: String? = null, message: Any)
}

@ThreadLocal
public expect object Logger : Log {

    public var mode: Mode
}
