@file:OptIn(InternalSerializationApi::class)

package com.javiersc.logger.serialization.internal

import com.javiersc.logger.Log
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@PublishedApi
internal fun prettyPrint(json: Json, tag: String?, jsonToPrint: String): String = try {
    json.encodeToString(json.parseToJsonElement(jsonToPrint))
} catch (exception: SerializationException) {
    Log.e(tag, exception)
    jsonToPrint
}

@PublishedApi
internal fun <T> prettyPrint(json: Json, tag: String?, serializer: KSerializer<T>, message: T): String = try {
    json.encodeToString(serializer, message)
} catch (exception: SerializationException) {
    Log.e(tag, exception)
    "$message"
}

@PublishedApi
internal inline fun <reified T> prettyPrint(json: Json, tag: String?, message: T): String = try {
    json.encodeToString(message)
} catch (exception: SerializationException) {
    Log.e(tag, exception)
    "$message"
}
