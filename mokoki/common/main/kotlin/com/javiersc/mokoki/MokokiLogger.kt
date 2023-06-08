package com.javiersc.mokoki

import kotlin.reflect.KType

public interface MokokiLogger {

    public var useCompatibleMode: Boolean

    public fun isLoggable(priority: Priority): Boolean

    public fun <T> log(
        kType: KType,
        priority: Priority,
        tag: String?,
        fileLink: String,
        fileName: String,
        classExhaustiveKind: String,
        className: String,
        functionName: String,
        lineNumber: Int,
        message: T,
    )

    public companion object {

        @PublishedApi internal val internalLoggers: MutableList<MokokiLogger> = mutableListOf()

        public val loggers: List<MokokiLogger>
            get() = internalLoggers

        public fun install(vararg loggers: MokokiLogger) {
            this.internalLoggers.addAll(loggers)
        }

        public fun uninstallAllLoggers() {
            internalLoggers.clear()
        }
    }
}
