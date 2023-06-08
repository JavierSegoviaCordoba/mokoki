package com.javiersc.mokoki

import kotlin.reflect.KType
import kotlin.reflect.typeOf

@Mokoki
public inline fun <reified T : Any> log(
    priority: Priority = Priority.VERBOSE,
    tag: String? = null,
    message: () -> T
) {
    val kType: KType = typeOf<T>()
    val fileLink = "?"
    val fileName = "?"
    val classExhaustiveKind = "class"
    val className = "?"
    val functionName = "?"
    val lineNumber = -1
    for (logger: MokokiLogger in MokokiLogger.loggers) {
        if (logger.isLoggable(priority)) {
            logger.log(
                kType = kType,
                priority = priority,
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

@Mokoki
public inline fun <reified T : Any> logV(tag: String? = null, message: () -> T) {
    log(priority = Priority.VERBOSE, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logD(tag: String? = null, message: () -> T) {
    log(priority = Priority.DEBUG, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logI(tag: String? = null, message: () -> T) {
    log(priority = Priority.INFO, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logW(tag: String? = null, message: () -> T) {
    log(priority = Priority.WARN, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logE(tag: String? = null, message: () -> T) {
    log(priority = Priority.ERROR, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logWTF(tag: String? = null, message: () -> T) {
    log(priority = Priority.ASSERT, tag = tag, message = message)
}
