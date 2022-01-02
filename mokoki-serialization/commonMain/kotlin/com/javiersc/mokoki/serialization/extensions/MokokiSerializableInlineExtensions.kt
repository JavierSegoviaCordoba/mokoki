package com.javiersc.mokoki.serialization.extensions

import com.javiersc.mokoki.serialization.MokokiSerialization
import kotlinx.serialization.serializer

public inline fun <reified T> logSerializableV(tag: String, message: T): Unit =
    MokokiSerialization.serializableV(tag, serializer(), message)

public inline fun <reified T> logSerializableV(message: T): Unit =
    MokokiSerialization.serializableV(serializer(), message)

public inline fun <reified T> logSerializableD(tag: String, message: T): Unit =
    MokokiSerialization.serializableD(tag, serializer(), message)

public inline fun <reified T> logSerializableD(message: T): Unit =
    MokokiSerialization.serializableD(serializer(), message)

public inline fun <reified T> logSerializableI(tag: String, message: T): Unit =
    MokokiSerialization.serializableI(tag, serializer(), message)

public inline fun <reified T> logSerializableI(message: T): Unit =
    MokokiSerialization.serializableI(serializer(), message)

public inline fun <reified T> logSerializableW(tag: String, message: T): Unit =
    MokokiSerialization.serializableW(tag, serializer(), message)

public inline fun <reified T> logSerializableW(message: T): Unit =
    MokokiSerialization.serializableW(serializer(), message)

public inline fun <reified T> logSerializableE(tag: String, message: T): Unit =
    MokokiSerialization.serializableE(tag, serializer(), message)

public inline fun <reified T> logSerializableE(message: T): Unit =
    MokokiSerialization.serializableE(serializer(), message)
