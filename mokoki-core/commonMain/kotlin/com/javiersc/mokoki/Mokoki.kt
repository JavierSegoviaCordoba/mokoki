@file:Suppress("TooManyFunctions", "TopLevelPropertyNaming")

package com.javiersc.mokoki

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
public object Mokoki {

    public var isEnabled: Boolean
        get() = logger.isEnabled
        set(value) {
            logger.isEnabled = value
        }

    public var enableCompatibleMode: Boolean
        get() = logger.enableCompatibleMode
        set(value) {
            logger.enableCompatibleMode = value
        }

    private var logger: MokokiLogger = MokokiLogger()

    public fun init(mokokiLogger: MokokiLogger) {
        logger = mokokiLogger
    }

    public fun v(tag: String = MokokiName, message: String): Unit = logger.v(tag, message)

    public fun v(tag: String = MokokiName, throwable: Throwable): Unit =
        logger.v(tag, throwable.stackTraceToString())

    public fun v(message: String): Unit = logger.v(MokokiName, message)

    public fun v(throwable: Throwable): Unit = logger.v(MokokiName, throwable.stackTraceToString())

    public fun d(tag: String = MokokiName, message: String): Unit = logger.d(tag, message)

    public fun d(tag: String = MokokiName, throwable: Throwable): Unit =
        logger.d(tag, throwable.stackTraceToString())

    public fun d(message: String): Unit = logger.d(MokokiName, message)

    public fun d(throwable: Throwable): Unit = logger.d(MokokiName, throwable.stackTraceToString())

    public fun i(tag: String = MokokiName, message: String): Unit = logger.i(tag, message)

    public fun i(tag: String = MokokiName, throwable: Throwable): Unit =
        logger.i(tag, throwable.stackTraceToString())

    public fun i(message: String): Unit = logger.i(MokokiName, message)
    public fun i(throwable: Throwable): Unit = logger.i(MokokiName, throwable.stackTraceToString())

    public fun w(tag: String = MokokiName, message: String): Unit = logger.w(tag, message)

    public fun w(tag: String = MokokiName, throwable: Throwable): Unit =
        logger.w(tag, throwable.stackTraceToString())

    public fun w(message: String): Unit = logger.w(MokokiName, message)

    public fun w(throwable: Throwable): Unit = logger.w(MokokiName, throwable.stackTraceToString())

    public fun e(tag: String = MokokiName, message: String): Unit = logger.e(tag, message)

    public fun e(tag: String = MokokiName, throwable: Throwable): Unit =
        logger.e(tag, throwable.stackTraceToString())

    public fun e(message: String): Unit = logger.e(MokokiName, message)

    public fun e(throwable: Throwable): Unit = logger.e(MokokiName, throwable.stackTraceToString())
}

private const val MokokiName = "Mokoki"
