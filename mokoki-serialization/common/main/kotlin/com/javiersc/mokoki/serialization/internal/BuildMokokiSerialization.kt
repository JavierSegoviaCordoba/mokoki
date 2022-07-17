package com.javiersc.mokoki.serialization.internal

import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.internal.buildMokokiMessage
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@PublishedApi
internal fun MokokiLogger.buildMokokiSerializationMessage(
    priority: Priority,
    tag: String?,
    json: Json,
    jsonToPrint: String,
): List<String> {
    val message =
        try {
            json.encodeToString(json.parseToJsonElement(jsonToPrint))
        } catch (exception: SerializationException) {
            jsonToPrint
        }
    return buildMokokiMessage(priority, tag, message)
}

@PublishedApi
internal fun <T : Any> MokokiLogger.buildMokokiSerializationMessage(
    priority: Priority,
    tag: String?,
    json: Json,
    serializer: KSerializer<Any?>,
    data: T
): List<String> {
    val message =
        try {
            json.encodeToString(serializer, data)
        } catch (exception: SerializationException) {
            data.toString()
        }
    return buildMokokiMessage(priority, tag, message)
}
