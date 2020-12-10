package com.javiersc.logger.serialization.extensions

import com.javiersc.logger.core.extensions.logD
import com.javiersc.logger.core.extensions.logE
import com.javiersc.logger.core.extensions.logI
import com.javiersc.logger.core.extensions.logV
import com.javiersc.logger.core.extensions.logW
import com.javiersc.logger.serialization.internal.prettyPrint

public inline fun <reified T> logSerializableV(tag: String, message: T): Unit = logV(tag, prettyPrint(tag, message))

public inline fun <reified T> logSerializableD(tag: String, message: T): Unit = logD(tag, prettyPrint(tag, message))

public inline fun <reified T> logSerializableI(tag: String, message: T): Unit = logI(tag, prettyPrint(tag, message))

public inline fun <reified T> logSerializableW(tag: String, message: T): Unit = logW(tag, prettyPrint(tag, message))

public inline fun <reified T> logSerializableE(tag: String, message: T): Unit = logE(tag, prettyPrint(tag, message))
