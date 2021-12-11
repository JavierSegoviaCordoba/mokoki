package com.javiersc.mokoki

import android.util.Log
import com.javiersc.mokoki.internal.AndroidLoggingHandler
import com.javiersc.mokoki.internal.Level
import com.javiersc.mokoki.internal.buildMokokiMessage

public actual class MokokiLogger {

    public actual var isEnabled: Boolean = true

    public actual var enableCompatibleMode: Boolean = false

    public var mode: MokokiMode = MokokiMode.Logcat

    init {
        AndroidLoggingHandler.reset(AndroidLoggingHandler())
    }

    public actual fun v(tag: String, message: String) {
        if (!isEnabled) return
        buildMokokiMessage(tag, message, Level.Verbose).forEach { Log.v(tag, it).addDelay() }
    }

    public actual fun d(tag: String, message: String) {
        if (!isEnabled) return
        buildMokokiMessage(tag, message, Level.Debug).forEach { Log.d(tag, it).addDelay() }
    }

    public actual fun i(tag: String, message: String) {
        if (!isEnabled) return
        buildMokokiMessage(tag, message, Level.Info).forEach { Log.i(tag, it).addDelay() }
    }

    public actual fun w(tag: String, message: String) {
        if (!isEnabled) return
        buildMokokiMessage(tag, message, Level.Warning).forEach { Log.w(tag, it).addDelay() }
    }

    public actual fun e(tag: String, message: String) {
        if (!isEnabled) return
        buildMokokiMessage(tag, message, Level.Error).forEach { Log.e(tag, it).addDelay() }
    }

    private fun Any.addDelay() = run { if (mode == MokokiMode.Run) Thread.sleep(0, delayInNanos) }

    public companion object {
        private const val delayInNanos = 800_000
    }
}

public enum class MokokiMode {
    Logcat,
    Run,
}
