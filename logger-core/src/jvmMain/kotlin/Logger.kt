package com.javiersc.logger.core

import com.javiersc.logger.core.LoggerForegroundColor.Black
import com.javiersc.logger.core.LoggerForegroundColor.Blue
import com.javiersc.logger.core.LoggerForegroundColor.Green
import com.javiersc.logger.core.LoggerForegroundColor.Red
import com.javiersc.logger.core.LoggerForegroundColor.Reset
import com.javiersc.logger.core.LoggerForegroundColor.Yellow
import com.javiersc.logger.core.Mode.Background
import com.javiersc.logger.core.Mode.Normal
import com.javiersc.logger.core.internal.Level.Verbose
import com.javiersc.logger.core.internal.print
import com.javiersc.logger.core.LoggerBackgroundColor.Blue as BlueBG
import com.javiersc.logger.core.LoggerBackgroundColor.Gray as GrayBG
import com.javiersc.logger.core.LoggerBackgroundColor.Green as GreenBG
import com.javiersc.logger.core.LoggerBackgroundColor.Red as RedBG
import com.javiersc.logger.core.LoggerBackgroundColor.Reset as ResetBG
import com.javiersc.logger.core.LoggerBackgroundColor.Yellow as YellowBG

public actual object Logger {

    public actual var mode: Mode = Normal
    public actual var isEnabled: Boolean = true

    public actual fun v(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Verbose, ResetBG, Reset)
            Background -> print(tag, message, Verbose, GrayBG, Black)
        }
    }

    public actual fun d(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Verbose, ResetBG, Green)
            Background -> print(tag, message, Verbose, GreenBG, Black)
        }
    }

    public actual fun i(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Verbose, ResetBG, Blue)
            Background -> print(tag, message, Verbose, BlueBG, Black)
        }
    }

    public actual fun w(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Verbose, ResetBG, Yellow)
            Background -> print(tag, message, Verbose, YellowBG, Black)
        }
    }

    public actual fun e(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Verbose, ResetBG, Red)
            Background -> print(tag, message, Verbose, RedBG, Black)
        }
    }

    public actual fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ) {
        if (!isEnabled) return

        print(tag, message, Verbose, backgroundColor, foregroundColor)
    }
}
