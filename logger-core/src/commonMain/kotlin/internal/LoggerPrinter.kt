package com.javiersc.logger.core.internal

internal fun print(
    tag: String?,
    message: Any,
    level: Level,
    background: Color = Color.Reset,
    foreground: Color = Color.Reset
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
    print(Color.Reset.value)
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
