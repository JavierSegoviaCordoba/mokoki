package com.javiersc.mokoki.internal

import com.javiersc.mokoki.MokokiException

internal actual val fileName
    get() = "file ${stackTrace?.fileName ?: "Unknown"}"

internal actual val className
    get() = "class ${
        stackTrace?.className?.split(".")?.lastOrNull() ?: "Unknown"
    }"

internal actual val methodName
    get() = "fun ${stackTrace?.methodName ?: "Unknown"}"

internal actual val lineNumber
    get() = "line ${stackTrace?.lineNumber ?: "Unknown"}"

internal actual val fileLink
    get() = "(${stackTrace?.fileName}:${stackTrace?.lineNumber})"

private data class StackTraceElement(
    val fileName: String,
    val className: String?,
    val methodName: String?,
    val lineNumber: String?,
)

private val stackTrace: StackTraceElement?
    get() =
        try {
            throw MokokiException()
        } catch (exception: MokokiException) {
            val lines = exception.getStackTrace().toList()
            val line =
                lines
                    .dropWhile { !it.contains("log(com.javiersc.mokoki.Priority") }
                    .dropWhile { it.contains("log(com.javiersc.mokoki.Priority") }
                    .dropWhile { !it.contains("FUNCTION_REFERENCE") }
                    .firstOrNull()

            val className: String? = line?.substringAfter('$')?.substringBefore('$')
            val fileName: String? = className?.let { "$it.kt" }
            val methodName: String? =
                line?.substringBefore("\$FUNCTION_REFERENCE")?.substringAfterLast('$')
            val lineNumber = "1"

            if (fileName != null && className != null && methodName != null && lineNumber != null) {
                StackTraceElement(fileName, className, methodName, lineNumber)
            } else {
                null
            }
        }
