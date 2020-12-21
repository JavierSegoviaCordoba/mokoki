package com.javiersc.logger.internal

import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor
import com.javiersc.logger.LoggerSeparator

internal fun print(
    tag: String?,
    message: Any,
    level: Level,
    background: LoggerBackgroundColor,
    foreground: LoggerForegroundColor,
) {
    val tagToPrint = if (tag != null) "$tag | " else ""
    val messageLines: List<String> = message.toString().lines()
    val colors = "${background.value}${foreground.value}"
    val header = "$tagToPrint$level.$fileLink │ $fileName │ $className │ $methodName │ $lineNumber"

    val maxLineSize = (listOf(header) + messageLines).maxOf(String::length)

    val internalSeparator = SeparatorSymbol.repeat(maxLineSize + 2)

    coloredPrint(colors, " ┌$internalSeparator┐ ")
    coloredPrint(colors, " │ $header │ ")
    coloredPrint(colors, " ├$internalSeparator┤ ")

    messageLines.forEach { line ->
        if (line.startsWith("├")) coloredPrint(colors, " $LoggerSeparator$internalSeparator│ ")
        else coloredPrint(colors, " │ $line${" ".repeat(maxLineSize - line.length)} │ ")
    }
    coloredPrint(colors, " └$internalSeparator┘ ")
}

internal const val SeparatorSymbolStart: String = "├"

private const val SeparatorSymbol: String = "─"

private fun coloredPrint(colors: String, message: String) {
    val resetColors = LoggerForegroundColor.Reset.value
    println("$colors$message$resetColors")
}
