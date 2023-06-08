package com.javiersc.mokoki

import com.javiersc.kotlin.stdlib.ansiColor
import com.javiersc.mokoki.internal.buildMokokiMessage
import kotlin.reflect.KClass
import kotlin.reflect.KType

public open class PrintMokokiLogger(
    private val minPriority: Priority = Priority.DEBUG,
) : MokokiLogger {

    override var useCompatibleMode: Boolean = false

    override fun isLoggable(priority: Priority): Boolean = priority.isLoggable(minPriority)

    override fun <T : Any> log(
        priority: Priority,
        tag: String?,
        kClass: KClass<T>,
        kType: KType,
        message: T,
    ) {
        val lines: List<String> = buildMokokiMessage(priority, tag, message)

        for (line in lines) {
            println(line.ansiColor(priority.ansiColor))
        }
    }
}
