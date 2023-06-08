@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package com.javiersc.mokoki.serialization._internal

import com.javiersc.mokoki.Priority
import com.javiersc.mokoki._internal.buildMokokiMessage
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal fun <T> buildMokokiSerializationMessage(
    priority: Priority,
    tag: String?,
    fileLink: String,
    fileName: String,
    classExhaustiveKind: String,
    className: String,
    functionName: String,
    lineNumber: Int,
    json: Json,
    serializer: KSerializer<Any?>?,
    data: T,
    useCompatibleMode: Boolean,
): String {
    val serializerData = runCatching { serializer?.let { json.encodeToString(serializer, data) } }
    val jsonElementData = runCatching { json.encodeToString(json.parseToJsonElement("$data")) }
    val defaultData = "$data"
    val message: String = serializerData.getOrNull() ?: jsonElementData.getOrNull() ?: defaultData
    return buildMokokiMessage(
        priority = priority,
        tag = tag,
        fileLink = fileLink,
        fileName = fileName,
        classExhaustiveKind = classExhaustiveKind,
        className = className,
        functionName = functionName,
        lineNumber = lineNumber,
        message = message,
        useCompatibleMode = useCompatibleMode,
    )
}
