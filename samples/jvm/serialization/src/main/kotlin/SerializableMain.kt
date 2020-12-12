@file:Suppress("MagicNumber")

package com.javiersc.logger.samples.jvm.serialization

import com.javiersc.logger.core.LoggerBackgroundColor.Yellow
import com.javiersc.logger.core.LoggerForegroundColor.BrightBlue
import com.javiersc.logger.core.Mode
import com.javiersc.logger.serialization.LogSerialization
import com.javiersc.logger.serialization.extensions.logJsonC
import com.javiersc.logger.serialization.extensions.logJsonD
import com.javiersc.logger.serialization.extensions.logJsonE
import com.javiersc.logger.serialization.extensions.logJsonI
import com.javiersc.logger.serialization.extensions.logJsonV
import com.javiersc.logger.serialization.extensions.logJsonW
import com.javiersc.logger.serialization.extensions.logSerializableC
import com.javiersc.logger.serialization.extensions.logSerializableD
import com.javiersc.logger.serialization.extensions.logSerializableE
import com.javiersc.logger.serialization.extensions.logSerializableI
import com.javiersc.logger.serialization.extensions.logSerializableV
import com.javiersc.logger.serialization.extensions.logSerializableW
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.modules.serializersModuleOf
import java.text.SimpleDateFormat
import java.util.Date

fun main() {
    App()
}

class App {

    init {
        showColors()

        serializersModuleExample()
    }

    private fun showColors() {
        LogSerialization.mode = Mode.Normal

        commonLogs()

        LogSerialization.mode = Mode.Background

        commonLogs()

        LogSerialization.isEnabled = false.also { println("isEnabled = false") }

        commonLogs()

        LogSerialization.isEnabled = true.also { println("isEnabled = true") }
    }

    private fun serializersModuleExample() {
        LogSerialization.apply {
            mode = Mode.Normal
            serializersModule = serializersModuleOf(DateSerializer)
        }
        logSerializableD("Dog with Contextual date", Dog.serializer(), dog)
    }

    private fun commonLogs() {
        logJsonV("SomeTag", userString)
        logSerializableV("SomeTag", User.serializer(), user)
        logJsonD("SomeTag", userString)
        logSerializableD("SomeTag", User.serializer(), user)
        logJsonI("SomeTag", userString)
        logSerializableI("SomeTag", User.serializer(), user)
        logJsonW("SomeTag", userString)
        logSerializableW("SomeTag", User.serializer(), user)
        logJsonE("SomeTag", userString)
        logSerializableE("SomeTag", User.serializer(), user)
        logJsonC("SomeTag", userString, Yellow, BrightBlue)
        logSerializableC("SomeTag", User.serializer(), user, Yellow, BrightBlue)
    }
}

@Serializable
data class User(val name: String, val age: Int, val hobbies: List<String>)

private val user = User("John", 19, listOf("Tennis", "Coding"))
private val userString =
    """
       | {
       |    "name": "Mike",
       |    "age": 22,
       |    "surnames": ["Football", "Reading"]
       | }
    """.trimMargin()

@Serializable
data class Dog(
    val name: String,
    @Contextual val birthday: Date
)

// 1362870000000 -> 2013-03-10
private val dog = Dog("Auri", Date(1362870000000))

object DateSerializer : KSerializer<Date> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Dog", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Date =
        SimpleDateFormat("yyyy-MM-dd").parse(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Date) =
        encoder.encodeString(SimpleDateFormat("yyyy-MM-dd").format(value))
}
