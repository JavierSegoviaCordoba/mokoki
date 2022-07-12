package com.javiersc.mokoki.test.internal

public actual val lineNumberForTest: Int
    get() = (stackTraceForTests?.lineNumber ?: -2) + 1

private val stackTraceForTests: StackTraceElement?
    get() =
        try {
            val trace = Thread.currentThread().stackTrace
            val index = trace.indexOfLast { it.isTestClass }
            trace[index]
        } catch (throwable: Throwable) {
            println("Mokoki has not been able to get the StackTrace")
            null
        }

private val StackTraceElement.isTestClass: Boolean
    get() = Regex("^(com.javiersc.mokoki)*.(Mokoki).*(Test)$").matches(className)
