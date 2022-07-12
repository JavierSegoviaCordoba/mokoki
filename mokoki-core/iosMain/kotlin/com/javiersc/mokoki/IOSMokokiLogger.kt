package com.javiersc.mokoki

import com.javiersc.mokoki.internal.buildMokokiMessage
import kotlin.reflect.KClass
import kotlin.reflect.KType
import platform.Foundation.NSLog
import platform.Foundation.NSString

public open class IOSMokokiLogger(
    private val minPriority: Priority = Priority.DEBUG,
) : MokokiLogger {

    override var useCompatibleMode: Boolean = false

    public var defaultTag: String = ""

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
            NSLog(message as NSString)
        }
    }
}
