package com.javiersc.mokoki

import com.javiersc.mokoki.Priority.ASSERT
import com.javiersc.mokoki.Priority.DEBUG
import com.javiersc.mokoki.Priority.ERROR
import com.javiersc.mokoki.Priority.INFO
import com.javiersc.mokoki.Priority.VERBOSE
import com.javiersc.mokoki.Priority.WARN
import kotlin.reflect.typeOf

public inline fun <reified T : Any> log(
    priority: Priority = DEBUG,
    tag: String? = null,
    message: () -> T
) {
    for (logger in MokokiLogger.loggers) {
        if (logger.isLoggable(priority)) logger.log(priority, tag, T::class, typeOf<T>(), message())
    }
}

public inline fun <reified T : Any> logV(tag: String? = null, message: () -> T) {
    log(priority = VERBOSE, tag = tag, message = message)
}

public inline fun <reified T : Any> logD(tag: String? = null, message: () -> T) {
    log(priority = DEBUG, tag = tag, message = message)
}

public inline fun <reified T : Any> logI(tag: String? = null, message: () -> T) {
    log(priority = INFO, tag = tag, message = message)
}

public inline fun <reified T : Any> logW(tag: String? = null, message: () -> T) {
    log(priority = WARN, tag = tag, message = message)
}

public inline fun <reified T : Any> logE(tag: String? = null, message: () -> T) {
    log(priority = ERROR, tag = tag, message = message)
}

public inline fun <reified T : Any> logWTF(tag: String? = null, message: () -> T) {
    log(priority = ASSERT, tag = tag, message = message)
}
