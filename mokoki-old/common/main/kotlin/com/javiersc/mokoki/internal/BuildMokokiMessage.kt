package com.javiersc.mokoki.internal

import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.Priority

public fun MokokiLogger.buildMokokiMessage(
    priority: Priority,
    tag: String?,
    message: Any,
): List<String> {
    val cornerUpLeft = if (useCompatibleMode) "-" else "┌"
    val cornerUpRight = if (useCompatibleMode) "-" else "┐"
    val cornerBottomLeft = if (useCompatibleMode) "-" else "└"
    val cornerBottomRight = if (useCompatibleMode) "-" else "┘"
    val vertical = if (useCompatibleMode) "|" else "│"
    val verticalLeft = if (useCompatibleMode) "|" else "├"
    val verticalRight = if (useCompatibleMode) "|" else "┤"

    val separatorSymbol: String = if (useCompatibleMode) "-" else "─"
    val separatorSymbolStart: String = if (useCompatibleMode) "|" else "├"

    val tagToPrint = if (tag != null) "$tag $vertical " else ""

    val messageLines: List<String> = buildMessageLines(message)

    val header = buildHeader(tagToPrint, priority, vertical)

    val maxLineLength = (listOf(header) + messageLines).maxOf(String::length)

    val internalSeparator = separatorSymbol.repeat(maxLineLength + 2)

    return buildList {
        val maxLineLengthMinusHeaderLength =
            ((maxLineLength - header.length).takeIf { it >= 0 } ?: 0) + 1
        val headerSpaces = " ".repeat(maxLineLengthMinusHeaderLength)
        add(" $cornerUpLeft$internalSeparator$cornerUpRight ")
        add(" $vertical $header$headerSpaces$vertical ")
        add(" $verticalLeft$internalSeparator$verticalRight ")

        messageLines.forEach { line ->
            if (line.startsWith(verticalLeft)) {
                add(" $separatorSymbolStart$internalSeparator$vertical ")
            } else {
                add(" $vertical $line${" ".repeat(maxLineLength - line.length)} $vertical ")
            }
        }
        add(" $cornerBottomLeft$internalSeparator$cornerBottomRight ")
    }
}

private fun buildMessageLines(message: Any) =
    when (message) {
        is Throwable -> message.stackTraceToString().lines()
        is String -> message.lines()
        else -> message.toString().lines()
    }

private fun buildHeader(tagToPrint: String, priority: Priority, vertical: String) =
    "$tagToPrint$priority.$fileLink $vertical " +
        "$fileName $vertical " +
        "$className $vertical " +
        "$methodName $vertical $lineNumber"
