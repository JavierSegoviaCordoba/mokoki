package com.javiersc.mokoki.serialization.extensions

import com.javiersc.mokoki.serialization.MokokiSerialization
import kotlinx.serialization.KSerializer

public fun <T> logSerializableV(tag: String, serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableV(tag, serializer, message)

public fun <T> logSerializableV(serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableV(serializer, message)

public fun <T> logSerializableD(tag: String, serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableD(tag, serializer, message)

public fun <T> logSerializableD(serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableD(serializer, message)

public fun <T> logSerializableI(tag: String, serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableI(tag, serializer, message)

public fun <T> logSerializableI(serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableI(serializer, message)

public fun <T> logSerializableW(tag: String, serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableW(tag, serializer, message)

public fun <T> logSerializableW(serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableW(serializer, message)

public fun <T> logSerializableE(tag: String, serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableE(tag, serializer, message)

public fun <T> logSerializableE(serializer: KSerializer<T>, message: T): Unit =
    MokokiSerialization.serializableE(serializer, message)
