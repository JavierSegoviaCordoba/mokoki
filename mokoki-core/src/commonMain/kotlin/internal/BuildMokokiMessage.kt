@file:Suppress("TopLevelPropertyNaming")

package com.javiersc.mokoki.internal

internal fun buildMokokiMessage(
    tag: String?,
    message: Any,
    level: Level,
): List<String> {
    val tagToPrint = if (tag != null) "$tag | " else ""
    val messageLines: List<String> = message.toString().lines()
    val header = "$tagToPrint$level.$fileLink │ $fileName │ $className │ $methodName │ $lineNumber"

    val maxLineSize = (listOf(header) + messageLines).maxOf(String::length)

    val internalSeparator = SeparatorSymbol.repeat(maxLineSize + 2)

    return buildList {
        add(" ┌$internalSeparator┐ ")
        add(" │ $header │ ")
        add(" ├$internalSeparator┤ ")

        messageLines.forEach { line ->
            if (line.startsWith("├")) add(" $SeparatorSymbolStart$internalSeparator│ ")
            else add(" │ $line${" ".repeat(maxLineSize - line.length)} │ ")
        }
        add(" └$internalSeparator┘ ")
    }
}

internal const val SeparatorSymbolStart: String = "├"

private const val SeparatorSymbol: String = "─"
