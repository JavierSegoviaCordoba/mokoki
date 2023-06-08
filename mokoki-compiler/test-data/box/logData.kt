package com.javiersc.mokoki.playground

import com.javiersc.mokoki.log

fun box(): String {
    log { Foo("bar") }
    return "OK"
}

class Foo(val bar: String)
