@file:OptIn(InternalSerializationApi::class)

package com.javiersc.mokoki.serialization.internal

import com.javiersc.mokoki.Mokoki
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@PublishedApi
internal fun buildMokokiMessage(tag: String, json: Json, jsonToPrint: String): String =
        try {
            json.encodeToString(json.parseToJsonElement(jsonToPrint))
        } catch (exception: SerializationException) {
            Mokoki.e(tag, exception)
            jsonToPrint
        }

@PublishedApi
internal fun <T> buildMokokiMessage(
    tag: String,
    json: Json,
    serializer: KSerializer<T>,
    message: T
): String =
        try {
            json.encodeToString(serializer, message)
        } catch (exception: SerializationException) {
            Mokoki.e(tag, exception)
            "$message"
        }
