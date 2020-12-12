package com.javiersc.logger.core.internal

internal actual val fileName get() = "file ${stackTrace?.fileName ?: "Unknown"}"

internal actual val className get() = "class ${stackTrace?.className?.split(".")?.lastOrNull() ?: "Unknown"}"

internal actual val methodName get() = "fun ${stackTrace?.methodName ?: "Unknown"}"

internal actual val lineNumber get() = "line ${stackTrace?.lineNumber ?: "Unknown"}"

internal actual val fileLink get() = "(${stackTrace?.fileName}:${stackTrace?.lineNumber})"

@Suppress("TooGenericExceptionCaught")
private val stackTrace: StackTraceElement?
    get() = try {
        val trace = Thread.currentThread().stackTrace
        val index = trace.indexOfLast { traceElement ->
            Regex("^(com.javiersc.*(logger|serialization).*(core|logger|serialization).*)$")
                .matches(traceElement.className)
        }
        trace[index + 1]
    } catch (throwable: Throwable) {
        null
    }
