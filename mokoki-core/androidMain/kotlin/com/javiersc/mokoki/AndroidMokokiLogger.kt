package com.javiersc.mokoki

import android.util.Log
import com.javiersc.mokoki.internal.buildMokokiMessage
import kotlin.reflect.KClass
import kotlin.reflect.KType

public open class AndroidMokokiLogger(
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

        val logTag = tag ?: defaultTag

        for (line in lines) {
            when (priority) {
                Priority.VERBOSE -> Log.v(logTag, line)
                Priority.DEBUG -> Log.d(logTag, line)
                Priority.INFO -> Log.i(logTag, line)
                Priority.WARN -> Log.w(logTag, line)
                Priority.ERROR -> Log.e(logTag, line)
                Priority.ASSERT -> Log.wtf(logTag, line)
            }
        }
    }
}
