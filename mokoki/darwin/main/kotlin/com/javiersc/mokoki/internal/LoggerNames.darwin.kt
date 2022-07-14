package com.javiersc.mokoki.internal

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
            throw IllegalStateException("MOKOKI INTERNAL ERROR")
        } catch (exception: IllegalStateException) {
            val lines = exception.getStackTrace().toList()
            val line =
                lines
                    .dropWhile { !it.contains("log(com.javiersc.mokoki.Priority") }
                    .dropWhile { it.contains("log(com.javiersc.mokoki.Priority") }
                    .firstOrNull()

            val fileName = line?.substringAfterLast("/")?.substringBefore(":")
            val className = line?.substringAfter("\$")?.substringBefore("\$")
            val methodName = line?.substringBefore("\$FUNCTION_REFERENCE")?.substringAfterLast("\$")
            val lineNumber = line?.substringAfterLast(".kt:")?.substringBefore(":")

            if (fileName != null && className != null && methodName != null && lineNumber != null) {
                StackTraceElement(fileName, className, methodName, lineNumber)
            } else {
                null
            }
        }