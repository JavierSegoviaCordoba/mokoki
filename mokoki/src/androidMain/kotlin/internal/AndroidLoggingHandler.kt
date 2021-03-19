@file:Suppress("EmptyFunctionBlock", "MagicNumber", "TooGenericExceptionCaught")

package com.javiersc.mokoki.internal

import android.util.Log
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.Level.INFO
import java.util.logging.Level.SEVERE
import java.util.logging.Level.WARNING
import java.util.logging.LogManager
import java.util.logging.LogRecord

internal class AndroidLoggingHandler : Handler() {
    override fun close() {}
    override fun flush() {}
    override fun publish(record: LogRecord) {
        if (!super.isLoggable(record)) return
        val name = record.loggerName
        val maxLength = 30
        val tag = if (name.length > maxLength) name.substring(name.length - maxLength) else name
        try {
            val level = getAndroidLevel(record.level)
            Log.println(level, tag, record.message)
            if (record.thrown != null) {
                Log.println(level, tag, Log.getStackTraceString(record.thrown))
            }
        } catch (throwable: Throwable) {
            Log.e("AndroidLoggingHandler", "Error logging message.", throwable)
        }
    }

    internal companion object {
        internal fun reset(rootHandler: Handler?) {
            val rootLogger = LogManager.getLogManager().getLogger("")
            val handlers = rootLogger.handlers
            for (handler in handlers) {
                rootLogger.removeHandler(handler)
            }
            rootHandler?.let(rootLogger::addHandler)
        }

        internal fun getAndroidLevel(level: Level): Int {
            val value: Int = level.intValue()
            return when {
                value >= SEVERE.intValue() -> Log.ERROR
                value >= WARNING.intValue() -> Log.WARN
                value >= INFO.intValue() -> Log.INFO
                else -> Log.DEBUG
            }
        }
    }
}
