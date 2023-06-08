package com.javiersc.mokoki

import com.javiersc.kotlin.stdlib.ansiColor
import com.javiersc.mokoki.internal.buildMokokiMessage
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import kotlin.reflect.KClass
import kotlin.reflect.KType

class TestMokokiLogger(minPriority: Priority) : PrintMokokiLogger(minPriority) {

    var lastMessage: String? = null
        private set

    override fun <T : Any> log(
        priority: Priority,
        tag: String?,
        kClass: KClass<T>,
        kType: KType,
        message: T
    ) {
        super.log(priority, tag, kClass, kType, message)

        val mokokiMessageLines: List<String> =
            buildMokokiMessage(priority, tag, message).map { it.ansiColor(priority.ansiColor) }

        lastMessage = mokokiMessageLines.joinToString("\n")
    }
}

fun TestMokokiLogger.assert(message: String) {
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

fun TestMokokiLogger.assertContains(message: String) {
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

    actual.shouldContain(expect)
}

private val Char.shouldDrop: Boolean
    get() = this != '┌' && this != '│' && this != '├' && this != '└'

private val Char.shouldDropLast: Boolean
    get() = this != '┐' && this != '│' && this != '┤' && this != '┘'
