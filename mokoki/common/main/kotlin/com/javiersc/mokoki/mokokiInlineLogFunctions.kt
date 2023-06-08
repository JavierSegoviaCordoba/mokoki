package com.javiersc.mokoki

import com.javiersc.mokoki._internal.internalLog
import kotlin.reflect.KType
import kotlin.reflect.typeOf

@Mokoki
public inline fun <reified T : Any> log(
    priority: Priority = Priority.VERBOSE,
    tag: String? = null,
    crossinline message: () -> T,
) {

    val kType: KType = typeOf<T>()
    val fileLink = "?"
    val fileName = "?"
    val classExhaustiveKind = "class"
    val className = "?"
    val functionName = "?"
    val lineNumber = -1

    internalLog(
        kType = kType,
        priority = priority,
        tag = tag,
        fileLink = fileLink,
        fileName = fileName,
        classExhaustiveKind = classExhaustiveKind,
        className = className,
        functionName = functionName,
        lineNumber = lineNumber,
        message = { message().toString() },
    )
}

@Mokoki
public inline fun <reified T : Any> logV(tag: String? = null, crossinline message: () -> T) {
    log(priority = Priority.VERBOSE, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logD(tag: String? = null, crossinline message: () -> T) {
    log(priority = Priority.DEBUG, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logI(tag: String? = null, crossinline message: () -> T) {
    log(priority = Priority.INFO, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logW(tag: String? = null, crossinline message: () -> T) {
    log(priority = Priority.WARN, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logE(tag: String? = null, crossinline message: () -> T) {
    log(priority = Priority.ERROR, tag = tag, message = message)
}

@Mokoki
public inline fun <reified T : Any> logWTF(tag: String? = null, crossinline message: () -> T) {
    log(priority = Priority.ASSERT, tag = tag, message = message)
}
