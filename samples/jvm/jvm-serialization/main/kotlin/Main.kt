@file:Suppress("MagicNumber")

package com.javiersc.mokoki.jvm.serialization

import com.javiersc.mokoki.LoggerSeparator
import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.logD
import com.javiersc.mokoki.logE
import com.javiersc.mokoki.logI
import com.javiersc.mokoki.logV
import com.javiersc.mokoki.logW
import com.javiersc.mokoki.logWTF
import com.javiersc.mokoki.serialization.PrintSerializableMokokiLogger
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual

fun main() {
    App(false)
    println("    ")
    println("------------------------------------------------------------")
    println("------------------------------------------------------------")
    println("    ")
    App(true)
}

class App(useCompatibleMode: Boolean) {

    init {
        showColors(useCompatibleMode)
    }

    private fun showColors(useCompatibleMode: Boolean) {
        MokokiLogger.uninstallAllLoggers()
        val printLogger =
            PrintSerializableMokokiLogger(minPriority = Priority.VERBOSE).apply {
                this.useCompatibleMode = useCompatibleMode
                serializersModule = SerializersModule { contextual(DateSerializer) }
            }
        MokokiLogger.install(printLogger)

        logV("SomeTag") { userString }
        logD("SomeTag") { userString }
        logI("SomeTag") { userString }
        logW("SomeTag") { userString }
        logE("SomeTag") { userString }
        logWTF("SomeTag") { userString }

        println("")
        println(" ------------------------------------------------------------")
        println("")

        logV("SomeTag") { user }
        logD("SomeTag") { user }
        logI("SomeTag") { user }
        logW("SomeTag") { user }
        logE("SomeTag") { user }
        logWTF("SomeTag") { user }

        println("")
        println(" ------------------------------------------------------------")
        println("")

        logV { userString }
        logD { userString }
        logI { userString }
        logW { userString }
        logE { userString }
        logWTF { userString }

        println("")
        println(" ------------------------------------------------------------")
        println("")

        logV { user }
        logD { user }
        logI { user }
        logW { user }
        logE { user }
        logWTF { user }

        println("")
        println(" ------------------------------------------------------------")
        println("")

        logV("Dog with Contextual date") { dog }

        val textWithSeparator =
            """
                Text before first separator
                ${LoggerSeparator(useCompatibleMode)}
                Text after first separator and before last separator
                ${LoggerSeparator(useCompatibleMode)}
                Text after last separator
            """.trimIndent()
        logV { textWithSeparator }
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
