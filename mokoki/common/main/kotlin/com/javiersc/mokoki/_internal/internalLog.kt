package com.javiersc.mokoki._internal

import com.javiersc.mokoki.Mokoki
import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.Priority
import kotlin.reflect.KType

@Mokoki
@PublishedApi
internal fun internalLog(
    priority: Priority? = null,
    tag: String? = null,
    kType: KType,
    fileLink: String,
    fileName: String,
    classExhaustiveKind: String,
    className: String,
    functionName: String,
    lineNumber: Int,
    message: () -> String,
) {
    val defaultPriority: Priority = priority ?: Priority.VERBOSE
    for (logger: MokokiLogger in MokokiLogger.loggers) {
        if (logger.isLoggable(defaultPriority)) {
            logger.log(
                kType = kType,
                priority = defaultPriority,
                tag = tag,
                fileLink = fileLink,
                fileName = fileName,
                classExhaustiveKind = classExhaustiveKind,
                className = className,
                functionName = functionName,
                lineNumber = lineNumber,
                message = message(),
            )
        }
    }
}
