package com.javiersc.logger.core.internal

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor

internal fun print(
    tag: String?,
    message: Any,
    level: Level,
    background: LoggerBackgroundColor = LoggerBackgroundColor.Reset,
    foreground: LoggerForegroundColor = LoggerForegroundColor.Reset,
) {
    val tagToPrint = if (tag != null) "$tag | " else ""
    val messageToPrint = message.toString().lines()
    print("${background.value}${foreground.value}")
    println(
        """ 
            ┌$SEPARATOR
            │ $tagToPrint$level.$fileLink │ $fileName │ $className │ $methodName │ $lineNumber
            ├$SEPARATOR
        """.trimIndent()
    )
    messageToPrint.forEach { line -> println("│ $line") }
    println("└$SEPARATOR")
    print(LoggerForegroundColor.Reset.value)
}

internal const val SEPARATOR = "───────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────" +
        "────────────────────────────────────────────────────────────────────────────────────────"
