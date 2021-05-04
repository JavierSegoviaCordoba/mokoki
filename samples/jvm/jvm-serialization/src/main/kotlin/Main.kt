@file:Suppress("MagicNumber")

package com.javiersc.mokoki.jvm.serialization

import com.javiersc.mokoki.serialization.MokokiSerialization
import com.javiersc.mokoki.serialization.extensions.logJsonD
import com.javiersc.mokoki.serialization.extensions.logJsonE
import com.javiersc.mokoki.serialization.extensions.logJsonI
import com.javiersc.mokoki.serialization.extensions.logJsonV
import com.javiersc.mokoki.serialization.extensions.logJsonW
import com.javiersc.mokoki.serialization.extensions.logSerializableD
import com.javiersc.mokoki.serialization.extensions.logSerializableE
import com.javiersc.mokoki.serialization.extensions.logSerializableI
import com.javiersc.mokoki.serialization.extensions.logSerializableV
import com.javiersc.mokoki.serialization.extensions.logSerializableW
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.logging.Logger
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.modules.serializersModuleOf

fun main() {
    App()
}

class App {

    init {
        showColors()

        serializersModuleExample()
    }

    private fun showColors() {
        commonLogs()

        MokokiSerialization.isEnabled = false.also { Logger.getGlobal().info("isEnabled = false") }

        commonLogs()

        MokokiSerialization.isEnabled = true.also { Logger.getGlobal().info("isEnabled = true") }
    }

    private fun serializersModuleExample() {
        MokokiSerialization.apply { serializersModule = serializersModuleOf(DateSerializer) }
        logSerializableV("Dog with Contextual date", Dog.serializer(), dog)
    }

    private fun commonLogs() {
        logJsonV("SomeTag", userString)
        logJsonD("SomeTag", userString)
        logJsonI("SomeTag", userString)
        logJsonW("SomeTag", userString)
        logJsonE("SomeTag", userString)
        logSerializableV("SomeTag", User.serializer(), user)
        logSerializableD("SomeTag", User.serializer(), user)
        logSerializableI("SomeTag", User.serializer(), user)
        logSerializableW("SomeTag", User.serializer(), user)
        logSerializableE("SomeTag", User.serializer(), user)
    }
}

@Serializable data class User(val name: String, val age: Int, val hobbies: List<String>)

private val user = User("John", 19, listOf("Tennis", "Coding"))
private val userString =
    """
       | {
       |    "name": "Mike",
       |    "age": 22,
       |    "surnames": ["Football", "Reading"]
       | }
    """.trimMargin()

@Serializable data class Dog(val name: String, @Contextual val birthday: Date)

// 1362870000000 -> 2013-03-10
private val dog = Dog("Auri", Date(1362870000000))

object DateSerializer : KSerializer<Date> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Dog", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Date =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(decoder.decodeString())!!

    override fun serialize(encoder: Encoder, value: Date) =
        encoder.encodeString(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(value))
}
