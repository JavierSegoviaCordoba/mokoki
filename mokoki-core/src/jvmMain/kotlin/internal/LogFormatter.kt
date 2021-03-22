package com.javiersc.mokoki.internal

import com.javiersc.mokoki.LoggerBackgroundColor
import com.javiersc.mokoki.LoggerForegroundColor
import java.util.logging.Formatter
import java.util.logging.LogRecord

internal class LogFormatter(
    private val loggerForegroundColor: LoggerForegroundColor = LoggerForegroundColor.White,
    private val loggerBackgroundColor: LoggerBackgroundColor? = null,
) : Formatter() {

    override fun format(record: LogRecord): String = buildString {
        append(loggerForegroundColor.value)
        loggerBackgroundColor?.value?.let(::append)
        append(record.message)
        append(LoggerForegroundColor.Reset.value)
        append("\n")
    }
}
