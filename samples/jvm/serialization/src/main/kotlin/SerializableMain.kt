@file:Suppress("MagicNumber")

package com.javiersc.logger.samples.jvm.serialization

import com.javiersc.logger.core.Logger
import com.javiersc.logger.core.LoggerBackgroundColor.Yellow
import com.javiersc.logger.core.LoggerForegroundColor.BrightBlue
import com.javiersc.logger.core.Mode
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
import kotlinx.serialization.Serializable

fun main() {
    App()
}

class App {

    init {
        showColors()
    }

    private fun showColors() {
        Logger.apply {
            mode = Mode.Normal
        }

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

        Logger.apply {
            mode = Mode.Background
        }

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
