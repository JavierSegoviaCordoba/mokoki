package com.javiersc.logger

import com.javiersc.logger.LoggerForegroundColor.Black
import com.javiersc.logger.LoggerForegroundColor.Blue
import com.javiersc.logger.LoggerForegroundColor.Green
import com.javiersc.logger.LoggerForegroundColor.Red
import com.javiersc.logger.LoggerForegroundColor.Reset
import com.javiersc.logger.LoggerForegroundColor.Yellow
import com.javiersc.logger.Mode.Background
import com.javiersc.logger.Mode.Normal
import com.javiersc.logger.internal.Level.Custom
import com.javiersc.logger.internal.Level.Debug
import com.javiersc.logger.internal.Level.Error
import com.javiersc.logger.internal.Level.Info
import com.javiersc.logger.internal.Level.Verbose
import com.javiersc.logger.internal.Level.Warning
import com.javiersc.logger.internal.print
import com.javiersc.logger.LoggerBackgroundColor.Blue as BlueBG
import com.javiersc.logger.LoggerBackgroundColor.Gray as GrayBG
import com.javiersc.logger.LoggerBackgroundColor.Green as GreenBG
import com.javiersc.logger.LoggerBackgroundColor.Red as RedBG
import com.javiersc.logger.LoggerBackgroundColor.Reset as ResetBG
import com.javiersc.logger.LoggerBackgroundColor.Yellow as YellowBG

public actual class Logger {

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
            Normal -> print(tag, message, Debug, ResetBG, Green)
            Background -> print(tag, message, Debug, GreenBG, Black)
        }
    }

    public actual fun i(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Info, ResetBG, Blue)
            Background -> print(tag, message, Info, BlueBG, Black)
        }
    }

    public actual fun w(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Warning, ResetBG, Yellow)
            Background -> print(tag, message, Warning, YellowBG, Black)
        }
    }

    public actual fun e(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Normal -> print(tag, message, Error, ResetBG, Red)
            Background -> print(tag, message, Error, RedBG, Black)
        }
    }

    public actual fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ) {
        if (!isEnabled) return

        print(tag, message, Custom, backgroundColor, foregroundColor)
    }
}