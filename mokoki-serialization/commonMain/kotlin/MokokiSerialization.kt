@file:Suppress("TooManyFunctions", "TopLevelPropertyNaming")

package com.javiersc.mokoki.serialization

import com.javiersc.mokoki.Mokoki
import com.javiersc.mokoki.serialization.internal.buildMokokiMessage
import kotlin.native.concurrent.ThreadLocal
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule

@ThreadLocal
public object MokokiSerialization {

    public var isEnabled: Boolean
        get() = Mokoki.isEnabled
        set(value) {
            Mokoki.isEnabled = value
        }

    public var enableCompatibleMode: Boolean
        get() = Mokoki.enableCompatibleMode
        set(value) {
            Mokoki.enableCompatibleMode = value
        }

    public var serializersModule: SerializersModule = EmptySerializersModule

    private val json: Json
        get() = Json {
            prettyPrint = true
            serializersModule = this@MokokiSerialization.serializersModule
        }

    public fun jsonV(tag: String, json: String): Unit =
        Mokoki.v(tag, buildMokokiMessage(tag, this.json, json))

    public fun <T> serializableV(tag: String, serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.v(tag, buildMokokiMessage(tag, json, serializer, serializable))

    public fun jsonV(json: String): Unit =
        Mokoki.v(MokokiName, buildMokokiMessage(MokokiName, this.json, json))

    public fun <T> serializableV(serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.v(MokokiName, buildMokokiMessage(MokokiName, json, serializer, serializable))

    public fun jsonD(tag: String, json: String): Unit =
        Mokoki.d(tag, buildMokokiMessage(tag, this.json, json))

    public fun <T> serializableD(tag: String, serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.d(tag, buildMokokiMessage(tag, json, serializer, serializable))

    public fun jsonD(json: String): Unit =
        Mokoki.d(MokokiName, buildMokokiMessage(MokokiName, this.json, json))

    public fun <T> serializableD(serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.d(MokokiName, buildMokokiMessage(MokokiName, json, serializer, serializable))

    public fun jsonI(tag: String, json: String): Unit =
        Mokoki.i(tag, buildMokokiMessage(tag, this.json, json))

    public fun <T> serializableI(tag: String, serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.i(tag, buildMokokiMessage(tag, json, serializer, serializable))

    public fun jsonI(json: String): Unit =
        Mokoki.i(MokokiName, buildMokokiMessage(MokokiName, this.json, json))

    public fun <T> serializableI(serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.i(MokokiName, buildMokokiMessage(MokokiName, json, serializer, serializable))

    public fun jsonW(tag: String, json: String): Unit =
        Mokoki.w(tag, buildMokokiMessage(tag, this.json, json))

    public fun <T> serializableW(tag: String, serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.w(tag, buildMokokiMessage(tag, json, serializer, serializable))

    public fun jsonW(json: String): Unit =
        Mokoki.w(MokokiName, buildMokokiMessage(MokokiName, this.json, json))

    public fun <T> serializableW(serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.w(MokokiName, buildMokokiMessage(MokokiName, json, serializer, serializable))

    public fun jsonE(tag: String, json: String): Unit =
        Mokoki.e(tag, buildMokokiMessage(tag, this.json, json))

    public fun <T> serializableE(tag: String, serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.e(tag, buildMokokiMessage(tag, json, serializer, serializable))

    public fun jsonE(json: String): Unit =
        Mokoki.e(MokokiName, buildMokokiMessage(MokokiName, this.json, json))

    public fun <T> serializableE(serializer: KSerializer<T>, serializable: T): Unit =
        Mokoki.e(MokokiName, buildMokokiMessage(MokokiName, json, serializer, serializable))
}

private const val MokokiName = "Mokoki"
