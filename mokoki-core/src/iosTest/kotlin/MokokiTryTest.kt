package com.javiersc.example.test

import com.javiersc.mokoki.Mokoki
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
