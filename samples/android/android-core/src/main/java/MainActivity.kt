@file:Suppress("MagicNumber")

package com.javiersc.mokoki.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.javiersc.mokoki.LoggerSeparator
import com.javiersc.mokoki.Mokoki
import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.extensions.logD
import com.javiersc.mokoki.extensions.logE
import com.javiersc.mokoki.extensions.logI
import com.javiersc.mokoki.extensions.logV
import com.javiersc.mokoki.extensions.logW
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
import kotlinx.serialization.json.JsonNull.serializer
import kotlinx.serialization.modules.serializersModuleOf

class MainActivity : AppCompatActivity(R.layout.main_activity) {

    @OptIn(ExperimentalStdlibApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mokoki.init(MokokiLogger())
        App()
    }
}

class App {

    init {
        showColors()
        showJsons()
    }

    private fun showColors() {
        Mokoki.isEnabled = true

        logV("SomeTag", "Unlucky bug")
        logD("SomeTag", "Unlucky bug")
        logI("SomeTag", "Unlucky bug")
        logW("SomeTag", "Unlucky bug")
        logE("SomeTag", "Unlucky bug")

        Logger.getGlobal().info("------------------------------------------------------------")

        logV("Example without TAG")
        logD("Example without TAG")
        logI("Example without TAG")
        logW("Example without TAG")
        logE("Example without TAG")

        Mokoki.isEnabled = false.also { Logger.getGlobal().info("isEnabled = false") }

        logV("This example should not appear")

        Mokoki.isEnabled = true.also { Logger.getGlobal().info("isEnabled = true") }

        val textWithSeparator =
            """
                Text before first separator
                ${LoggerSeparator()}
                Text after first separator and before last separator
                ${LoggerSeparator()}
                Text after last separator
            """.trimIndent()
        logV(textWithSeparator)
    }

    private fun showJsons() {
        commonLogs()

        MokokiSerialization.isEnabled = false.also { Logger.getGlobal().info("isEnabled = false") }

        commonLogs()

        MokokiSerialization.isEnabled = true.also { Logger.getGlobal().info("isEnabled = true") }

        serializersModuleExample()
    }

    private fun serializersModuleExample() {
        MokokiSerialization.serializersModule = serializersModuleOf(DateSerializer)

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
