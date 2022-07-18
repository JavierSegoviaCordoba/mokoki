package com.javiersc.mokoki.serialization

import com.javiersc.mokoki.Priority
import io.kotest.matchers.shouldBe
import kotlin.reflect.KClass
import kotlin.reflect.KType

internal class TestMokokiSerializationLogger(
    minPriority: Priority,
) : PrintSerializableMokokiLogger(minPriority) {

    var lastMessage: String? = null
        private set

    override fun <T : Any> log(
        priority: Priority,
        tag: String?,
        kClass: KClass<T>,
        kType: KType,
        message: T,
    ) {
        super.log(priority, tag, kClass, kType, message)

        val lines: List<String> = buildLines(serializer(kType, message), priority, tag, message)
        lastMessage = lines.joinToString("\n")
    }
}

internal fun TestMokokiSerializationLogger.assert(message: String) {
    val expect =
        "\n" +
            (message
                .lines()
                .filter(String::isNotBlank)
                .map { it.dropWhile { char -> char.shouldDrop } }
                .map { it.dropLastWhile { char -> char.shouldDropLast } }
                .joinToString("\n"))

    val actual =
        "\n" +
            (lastMessage!!
                .lines()
                .filter(String::isNotBlank)
                .map { it.dropWhile { char -> char.shouldDrop } }
                .map { it.dropLastWhile { char -> char.shouldDropLast } }
                .joinToString("\n"))

    actual.shouldBe(expect)
}

private val Char.shouldDrop: Boolean
    get() = this != '┌' && this != '│' && this != '├' && this != '└'

private val Char.shouldDropLast: Boolean
    get() = this != '┐' && this != '│' && this != '┤' && this != '┘'
