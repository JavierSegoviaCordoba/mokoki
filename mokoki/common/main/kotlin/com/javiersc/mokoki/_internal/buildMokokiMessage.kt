package com.javiersc.mokoki._internal

import com.javiersc.mokoki.Priority

internal fun <T> buildMokokiMessage(
    priority: Priority,
    tag: String?,
    fileLink: String,
    fileName: String,
    classExhaustiveKind: String,
    className: String,
    functionName: String,
    lineNumber: Int,
    message: T,
    useCompatibleMode: Boolean,
): String {
    fun buildMessageLines(message: T): List<String> =
        when (message) {
            is Throwable -> message.stackTraceToString().lines()
            is String -> message.lines()
            else -> message.toString().lines()
        }

    fun buildHeader(tagToPrint: String, priority: Priority, vertical: String): String =
        "$tagToPrint$priority.$fileLink $vertical " +
            "file $fileName $vertical " +
            "$classExhaustiveKind $className $vertical " +
            "fun $functionName $vertical line $lineNumber"

    val cornerUpLeft: String = if (useCompatibleMode) "-" else "┌"
    val cornerUpRight: String = if (useCompatibleMode) "-" else "┐"
    val cornerBottomLeft: String = if (useCompatibleMode) "-" else "└"
    val cornerBottomRight: String = if (useCompatibleMode) "-" else "┘"
    val vertical: String = if (useCompatibleMode) "|" else "│"
    val verticalLeft: String = if (useCompatibleMode) "|" else "├"
    val verticalRight: String = if (useCompatibleMode) "|" else "┤"

    val separatorSymbol: String = if (useCompatibleMode) "-" else "─"
    val separatorSymbolStart: String = if (useCompatibleMode) "|" else "├"

    val tagToPrint: String = if (tag != null) "$tag $vertical " else ""
    val messageLines: List<String> = buildMessageLines(message)
    val header: String = buildHeader(tagToPrint, priority, vertical)
    val maxLineLength: Int = (listOf(header) + messageLines).maxOf(String::length)
    val internalSeparator: String = separatorSymbol.repeat(maxLineLength + 2)

    return buildString {
        val maxLineLengthMinusHeaderLength: Int =
            ((maxLineLength - header.length).takeIf { it >= 0 } ?: 0) + 1
        val headerSpaces = " ".repeat(maxLineLengthMinusHeaderLength)
        appendLine(" $cornerUpLeft$internalSeparator$cornerUpRight ")
        appendLine(" $vertical $header$headerSpaces$vertical ")
        appendLine(" $verticalLeft$internalSeparator$verticalRight ")

        messageLines.forEach { line ->
            if (line.startsWith(verticalLeft)) {
                appendLine(" $separatorSymbolStart$internalSeparator$vertical ")
            } else {
                appendLine(" $vertical $line${" ".repeat(maxLineLength - line.length)} $vertical ")
            }
        }
        appendLine(" $cornerBottomLeft$internalSeparator$cornerBottomRight ")
    }
}
