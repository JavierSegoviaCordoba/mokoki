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

@Suppress("TooGenericExceptionCaught", "SwallowedException")
private val stackTrace: StackTraceElement?
    get() =
        try {
            val trace = Thread.currentThread().stackTrace
            val index =
                trace.indexOfLast { traceElement ->
                    Regex("^(Mokoki.kt)$").matches(traceElement.fileName ?: "") &&
                        Regex("^(com.javiersc.mokoki.Mokoki)$").matches(traceElement.className)
                }
            trace[index + 1]
        } catch (throwable: Throwable) {
            println("Mokoki has not been able to get the StackTrace")
            null
        }
