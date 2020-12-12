@file:OptIn(InternalSerializationApi::class)

package com.javiersc.logger.serialization.internal

import com.javiersc.logger.core.Log
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@PublishedApi
internal val json: Json = Json { prettyPrint = true }

@PublishedApi
internal fun prettyPrint(jsonToPrint: String): String = json.encodeToString(json.parseToJsonElement(jsonToPrint))

@PublishedApi
internal inline fun <reified T> prettyPrint(tag: String?, message: T): String = try {
    json.encodeToString(message)
} catch (exception: SerializationException) {
    Log.e(tag, exception)
    "$message"
}
