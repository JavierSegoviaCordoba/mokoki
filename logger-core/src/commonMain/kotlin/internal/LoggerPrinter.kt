package com.javiersc.logger.core.internal

import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor

internal fun print(
    tag: String?,
    message: Any,
    level: Level,
    background: LoggerBackgroundColor,
    foreground: LoggerForegroundColor,
) {
    val tagToPrint = if (tag != null) "$tag | " else ""
    val messageToPrint = message.toString().lines()
    print("${background.value}${foreground.value}")
    println(
        """ 
            ┌$InternalSeparator
            │ $tagToPrint$level.$fileLink │ $fileName │ $className │ $methodName │ $lineNumber
            ├$InternalSeparator
        """.trimIndent()
    )
    messageToPrint.forEach { line -> if (line.startsWith("├")) println(line) else println("│ $line") }
    println("└$InternalSeparator")
    print(LoggerForegroundColor.Reset.value)
}

public const val SeparatorSymbolStart: String = "├"

public const val SeparatorSymbol: String = "─"

internal val InternalSeparator = SeparatorSymbol.repeat(1000)

public val Separator: String = SeparatorSymbolStart + InternalSeparator.removeRange(0, 1)
