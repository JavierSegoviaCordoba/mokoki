@file:Suppress("TopLevelPropertyNaming")

package com.javiersc.mokoki.internal

import com.javiersc.mokoki.MokokiLogger

internal fun MokokiLogger.buildMokokiMessage(
    tag: String?,
    message: Any,
    level: Level,
): List<String> {
    val cornerUpLeft = if (enableCompatibleMode) "-" else "┌"
    val cornerUpRight = if (enableCompatibleMode) "-" else "┐"
    val cornerBottomLeft = if (enableCompatibleMode) "-" else "└"
    val cornerBottomRight = if (enableCompatibleMode) "-" else "┘"
    val vertical = if (enableCompatibleMode) "|" else "│"
    val verticalLeft = if (enableCompatibleMode) "|" else "├"
    val verticalRight = if (enableCompatibleMode) "|" else "┤"

    val separatorSymbol: String = if (enableCompatibleMode) "-" else "─"
    val separatorSymbolStart: String = if (enableCompatibleMode) "|" else "├"

    val tagToPrint = if (tag != null) "$tag $vertical " else ""
    val messageLines: List<String> = message.toString().lines()
    val header =
        "$tagToPrint$level.$fileLink $vertical " +
            "$fileName $vertical " +
            "$className $vertical " +
            "$methodName $vertical $lineNumber"

    val maxLineSize = (listOf(header) + messageLines).maxOf(String::length)

    val internalSeparator = separatorSymbol.repeat(maxLineSize + 2)

    return buildList {
        add(" $cornerUpLeft$internalSeparator$cornerUpRight ")
        add(" $vertical $header $vertical ")
        add(" $verticalLeft$internalSeparator$verticalRight ")

        messageLines.forEach { line ->
            if (line.startsWith(verticalLeft)) {
                add(" $separatorSymbolStart$internalSeparator$vertical ")
            } else {
                add(" $vertical $line${" ".repeat(maxLineSize - line.length)} $vertical ")
            }
        }
        add(" $cornerBottomLeft$internalSeparator$cornerBottomRight ")
    }
}
