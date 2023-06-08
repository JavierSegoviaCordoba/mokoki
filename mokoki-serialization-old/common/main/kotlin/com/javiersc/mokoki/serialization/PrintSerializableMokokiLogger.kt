package com.javiersc.mokoki.serialization

import com.javiersc.kotlin.stdlib.ansiColor
import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.serialization.internal.buildMokokiSerializationMessage
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializerOrNull

public open class PrintSerializableMokokiLogger(
    private val minPriority: Priority = Priority.DEBUG,
) : MokokiLogger {

    override var useCompatibleMode: Boolean = false

    public var serializersModule: SerializersModule = EmptySerializersModule

    internal val json: Json
        get() = Json {
            prettyPrint = true
            serializersModule = this@PrintSerializableMokokiLogger.serializersModule
        }

    override fun isLoggable(priority: Priority): Boolean = priority.isLoggable(minPriority)

    override fun <T : Any> log(
        priority: Priority,
        tag: String?,
        kClass: KClass<T>,
        kType: KType,
        message: T
    ) {
        val lines: List<String> = buildLines(serializer(kType, message), priority, tag, message)

        for (line in lines) {
            println(line.ansiColor(priority.ansiColor))
        }
    }

    internal fun <T : Any> buildLines(
        serializer: KSerializer<Any?>?,
        priority: Priority,
        tag: String?,
        message: T
    ): List<String> {
        val lines: List<String> =
            if (serializer != null) {
                buildMokokiSerializationMessage(priority, tag, json, serializer, message)
            } else {
                buildMokokiSerializationMessage(priority, tag, json, "$message")
            }
        return lines
    }

    internal fun <T> serializer(kType: KType, message: T): KSerializer<Any?>? =
        serializerOrNull(kType).takeIf { message !is String }
}
