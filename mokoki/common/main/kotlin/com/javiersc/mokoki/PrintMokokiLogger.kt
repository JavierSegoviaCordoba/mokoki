package com.javiersc.mokoki

import com.javiersc.kotlin.stdlib.ansiColor
import com.javiersc.mokoki.Priority.VERBOSE
import com.javiersc.mokoki._internal.buildMokokiMessage
import kotlin.reflect.KType

public open class PrintMokokiLogger(private val minPriority: Priority = VERBOSE) : MokokiLogger {

    override var useCompatibleMode: Boolean = false

    override fun isLoggable(priority: Priority): Boolean = priority.isLoggable(minPriority)

    override fun <T> log(
        kType: KType,
        priority: Priority,
        tag: String?,
        fileLink: String,
        fileName: String,
        classExhaustiveKind: String,
        className: String,
        functionName: String,
        lineNumber: Int,
        message: T,
    ) {
        val mokokiMessage: String =
            buildMokokiMessage(
                priority = priority,
                tag = tag,
                fileLink = fileLink,
                fileName = fileName,
                classExhaustiveKind = classExhaustiveKind,
                className = className,
                functionName = functionName,
                lineNumber = lineNumber,
                message = message,
                useCompatibleMode = useCompatibleMode,
            )

        for (line: String in mokokiMessage.lines()) {
            println(line.ansiColor(priority.ansiColor))
        }
    }
}
