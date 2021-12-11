package com.javiersc.mokoki

import com.javiersc.mokoki.internal.Level
import com.javiersc.mokoki.internal.buildMokokiMessage

public actual class MokokiLogger {

    public actual var isEnabled: Boolean = true

    public actual var enableCompatibleMode: Boolean = false

    public actual fun v(tag: String, message: String) {
        buildMokokiMessage(tag, message, Level.Verbose).forEach { println(it) }
    }

    public actual fun d(tag: String, message: String) {
        TODO()
    }

    public actual fun i(tag: String, message: String) {
        TODO()
    }

    public actual fun w(tag: String, message: String) {
        TODO()
    }

    public actual fun e(tag: String, message: String) {
        TODO()
    }
}
