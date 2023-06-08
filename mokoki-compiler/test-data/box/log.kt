package com.javiersc.mokoki.playground

import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.log

fun box(): String = Log.box()

object Log {

    init {
        log { "some message 0" }
    }

    fun box(): String {
        log { "some message 1" }
        log(tag = "tag 2") { "some message 2" }
        log(message = { "some message 3" })
        log(priority = Priority.DEBUG) { "some message 4" }
        log(priority = Priority.INFO, tag = "tag 5") { "some message 5" }
        log(priority = Priority.WARN, tag = "tag 6", message = { "some message 6" })
        log(message = { "some message 7" }, tag = "tag 7", priority = Priority.ERROR)
        log(message = { "some message 8" }, priority = Priority.ASSERT, tag = "tag 8")
        return "OK"
    }
}
