package com.javiersc.logger.core.internal

internal actual val fileName get() = "file ${stackTrace?.fileName ?: "Unknown"}"

internal actual val className get() = "class ${stackTrace?.className ?: "Unknown"}"

internal actual val methodName get() = "fun ${stackTrace?.methodName ?: "Unknown"}"

internal actual val lineNumber get() = "line ${stackTrace?.lineNumber ?: "Unknown"}"

internal actual val fileLink get() = "(${stackTrace?.fileName}:${stackTrace?.lineNumber})"

private val stackTrace: StackTraceElement?
    get() = Thread.currentThread().stackTrace.run {
        val index = indexOfLast { Regex("^log(|Json|Serializable)[VDIWE]$").matches(it.methodName) }
        return get(index + 1)
    }
