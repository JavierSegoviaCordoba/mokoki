package com.javiersc.mokoki

import com.javiersc.mokoki.internal.Level.Debug
import com.javiersc.mokoki.internal.Level.Error
import com.javiersc.mokoki.internal.Level.Info
import com.javiersc.mokoki.internal.Level.Verbose
import com.javiersc.mokoki.internal.Level.Warning
import com.javiersc.mokoki.internal.LogFormatter
import com.javiersc.mokoki.internal.buildMokokiMessage
import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger

public actual class MokokiLogger {

    public actual var isEnabled: Boolean = true

    public actual var enableCompatibleMode: Boolean = false

    private val logger = Logger.getLogger("Mokoki")

    init {
        logger.apply {
            handlers.forEach(::removeHandler)
            level = Level.ALL
            useParentHandlers = false
            addHandler(
                ConsoleHandler().apply {
                    level = Level.ALL
                    formatter = LogFormatter()
                },
            )
        }
    }

    public actual fun v(tag: String, message: String) {
        if (!isEnabled) return
        logger.apply {
            colors(LoggerForegroundColor.Green, null)
            buildMokokiMessage(tag, message, Verbose).forEach(::finer)
        }
    }

    public actual fun d(tag: String, message: String) {
        if (!isEnabled) return
        logger.apply {
            colors(LoggerForegroundColor.White, null)
            buildMokokiMessage(tag, message, Debug).forEach(::fine)
        }
    }

    public actual fun i(tag: String, message: String) {
        if (!isEnabled) return
        logger.apply {
            colors(LoggerForegroundColor.Yellow, null)
            buildMokokiMessage(tag, message, Info).forEach(::info)
        }
    }

    public actual fun w(tag: String, message: String) {
        if (!isEnabled) return
        logger.apply {
            colors(LoggerForegroundColor.BrightYellow, null)
            buildMokokiMessage(tag, message, Warning).forEach(::warning)
        }
    }

    public actual fun e(tag: String, message: String) {
        if (!isEnabled) return
        logger.apply {
            colors(LoggerForegroundColor.Red, null)
            buildMokokiMessage(tag, message, Error).forEach(::severe)
        }
    }

    private fun Logger.colors(
        loggerForegroundColor: LoggerForegroundColor,
        loggerBackgroundColor: LoggerBackgroundColor?,
    ) {
        handlers[0].formatter = LogFormatter(loggerForegroundColor, loggerBackgroundColor)
    }
}
