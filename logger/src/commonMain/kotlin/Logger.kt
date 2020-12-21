package com.javiersc.logger

import com.javiersc.logger.LoggerForegroundColor.Black
import com.javiersc.logger.LoggerForegroundColor.Blue
import com.javiersc.logger.LoggerForegroundColor.Cyan
import com.javiersc.logger.LoggerForegroundColor.Green
import com.javiersc.logger.LoggerForegroundColor.Red
import com.javiersc.logger.LoggerForegroundColor.Reset
import com.javiersc.logger.LoggerForegroundColor.Yellow
import com.javiersc.logger.internal.Level
import com.javiersc.logger.internal.print
import com.javiersc.logger.LoggerBackgroundColor.Blue as BlueBG
import com.javiersc.logger.LoggerBackgroundColor.Cyan as CyanBG
import com.javiersc.logger.LoggerBackgroundColor.Gray as GrayBG
import com.javiersc.logger.LoggerBackgroundColor.Green as GreenBG
import com.javiersc.logger.LoggerBackgroundColor.Red as RedBG
import com.javiersc.logger.LoggerBackgroundColor.Reset as ResetBG
import com.javiersc.logger.LoggerBackgroundColor.Yellow as YellowBG

public class Logger {

    public var mode: Mode = Mode.Normal
    public var isEnabled: Boolean = true

    public fun v(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Mode.Normal -> print(tag, message, Level.Verbose, ResetBG, Reset)
            Mode.Background -> print(tag, message, Level.Verbose, GrayBG, Black)
        }
    }

    public fun d(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Mode.Normal -> print(tag, message, Level.Debug, ResetBG, Cyan)
            Mode.Background -> print(tag, message, Level.Debug, CyanBG, Black)
        }
    }

    public fun s(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Mode.Normal -> print(tag, message, Level.Success, ResetBG, Green)
            Mode.Background -> print(tag, message, Level.Success, GreenBG, Black)
        }
    }

    public fun i(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Mode.Normal -> print(tag, message, Level.Info, ResetBG, Blue)
            Mode.Background -> print(tag, message, Level.Info, BlueBG, Black)
        }
    }

    public fun w(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Mode.Normal -> print(tag, message, Level.Warning, ResetBG, Yellow)
            Mode.Background -> print(tag, message, Level.Warning, YellowBG, Black)
        }
    }

    public fun e(tag: String?, message: Any) {
        if (!isEnabled) return

        when (mode) {
            Mode.Normal -> print(tag, message, Level.Error, ResetBG, Red)
            Mode.Background -> print(tag, message, Level.Error, RedBG, Black)
        }
    }

    public fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ) {
        if (!isEnabled) return

        print(tag, message, Level.Custom, backgroundColor, foregroundColor)
    }
}
