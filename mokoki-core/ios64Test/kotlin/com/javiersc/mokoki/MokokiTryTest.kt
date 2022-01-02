package com.javiersc.mokoki

import com.javiersc.mokoki.extensions.logV
import kotlin.test.Test

class MokokiTry {

    @Test
    fun hello() {
        hi()
    }

    @Test
    fun hello2() {
        SomeObject.greeting()
    }
}

fun hi() {
    Mokoki.v("Hello")
}

object SomeObject {
    fun greeting() {
        logV("Hello")
    }
}
