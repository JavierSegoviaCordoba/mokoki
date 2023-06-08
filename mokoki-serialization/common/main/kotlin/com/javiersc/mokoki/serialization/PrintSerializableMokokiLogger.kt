package com.javiersc.mokoki.serialization

import com.javiersc.kotlin.stdlib.ansiColor
import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.serialization._internal.buildMokokiSerializationMessage
import kotlin.reflect.KType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializerOrNull

public open class PrintSerializableMokokiLogger(
    private val minPriority: Priority = Priority.VERBOSE
) : MokokiLogger {

    override var useCompatibleMode: Boolean = false

    public var serializersModule: SerializersModule = EmptySerializersModule()

    private val json: Json
        get() = Json {
            prettyPrint = true
            serializersModule = this@PrintSerializableMokokiLogger.serializersModule
        }

    override fun isLoggable(priority: Priority): Boolean = priority.isLoggable(minPriority)

    override fun <T> log(
        kType: KType,
        priority: Priority,
        tag: String?,
        fileLink: String,
        fileName: String,
        classExhaustiveKind: String,
        className: String,
        functionName: String,
        lineNumber: Int,
        message: T,
    ) {
        val messageLines: List<String> =
            buildMokokiSerializationMessage(
                    priority = priority,
                    tag = tag,
                    fileLink = fileLink,
                    fileName = fileName,
                    className = className,
                    classExhaustiveKind = classExhaustiveKind,
                    functionName = functionName,
                    lineNumber = lineNumber,
                    json = json,
                    serializer = serializer(kType, message),
                    data = message,
                    useCompatibleMode = useCompatibleMode,
                )
                .lines()

        for (line in messageLines) {
            println(line.ansiColor(priority.ansiColor))
        }
    }

    private fun <T> serializer(kType: KType, message: T): KSerializer<Any?>? =
        serializerOrNull(kType).takeIf { message !is String }
}
