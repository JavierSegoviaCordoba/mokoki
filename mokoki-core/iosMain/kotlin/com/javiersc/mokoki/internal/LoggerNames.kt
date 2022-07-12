package com.javiersc.mokoki.internal

import platform.Foundation.NSThread

internal actual val fileName
    get() = "file ${stackTrace?.fileName ?: "Unknown"}"

internal actual val className
    get() = "class ${
        stackTrace?.className?.split(".")?.lastOrNull() ?: "Unknown"
    }"

internal actual val methodName
    get() = "fun ${stackTrace?.methodName ?: "Unknown"}"

internal actual val lineNumber
    get() = "line Unknown"

internal actual val fileLink
    get() = "(${stackTrace?.fileName}:${stackTrace?.lineNumber})"

private data class StackTraceElement(
    val fileName: String,
    val className: String?,
    val methodName: String?,
    val lineNumber: String?,
)

@Suppress("TooGenericExceptionCaught")
private val stackTrace: StackTraceElement?
    get() =
        try {
            val lines: List<String?> = NSThread.callStackSymbols.map { it?.toString() }
            val index = 6
            val fileName =
                if (
                    lines[index]
                        ?.replaceAfter("#", "")
                        ?.replace("#", "")
                        ?.replaceBeforeLast(".", "")
                        ?.replace(".", "")
                        ?.first()
                        ?.isUpperCase() == true
                ) {
                    lines[index]
                        ?.replaceAfter("#", "")
                        ?.replace("#", "")
                        ?.replaceBeforeLast(".", "")
                        ?.replace(".", "")
                } else {
                    lines[index + 1]
                        ?.replaceBefore("$", "")
                        ?.replaceFirst("$", "")
                        ?.replaceAfter("$", "")
                        ?.replace("$", "")
                }

            val methodName =
                lines[index]
                    ?.replaceBefore("#", "")
                    ?.replace("#", "")
                    ?.replaceAfter("(", "")
                    ?.replace("(", "")

            StackTraceElement(
                fileName = fileName?.let { "$it.kt" } ?: "Unknown",
                className = fileName ?: "Unknown",
                methodName = methodName,
                lineNumber = "1"
            )
        } catch (throwable: Throwable) {
            println("Mokoki has not been able to get the StackTrace")
            null
        }
