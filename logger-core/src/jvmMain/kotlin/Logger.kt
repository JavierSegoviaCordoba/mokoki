package com.javiersc.logger.core

import com.javiersc.logger.core.LoggerForegroundColor.Black
import com.javiersc.logger.core.LoggerForegroundColor.Blue
import com.javiersc.logger.core.LoggerForegroundColor.Green
import com.javiersc.logger.core.LoggerForegroundColor.Red
import com.javiersc.logger.core.LoggerForegroundColor.Yellow
import com.javiersc.logger.core.Mode.Background
import com.javiersc.logger.core.Mode.Normal
import com.javiersc.logger.core.internal.Level.Verbose
import com.javiersc.logger.core.internal.print
import com.javiersc.logger.core.LoggerBackgroundColor.Blue as BlueBG
import com.javiersc.logger.core.LoggerBackgroundColor.Gray as GrayBG
import com.javiersc.logger.core.LoggerBackgroundColor.Green as GreenBG
import com.javiersc.logger.core.LoggerBackgroundColor.Red as RedBG
import com.javiersc.logger.core.LoggerBackgroundColor.Yellow as YellowBG

public actual object Logger {

    public actual var mode: Mode = Normal

    public actual fun v(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose)
        Background -> print(tag = tag, message = message, level = Verbose, background = GrayBG, foreground = Black)
    }

    public actual fun d(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Green)
        Background -> print(tag = tag, message = message, level = Verbose, background = GreenBG, foreground = Black)
    }

    public actual fun i(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Blue)
        Background -> print(tag = tag, message = message, level = Verbose, background = BlueBG, foreground = Black)
    }

    public actual fun w(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Yellow)
        Background -> print(tag = tag, message = message, level = Verbose, background = YellowBG, foreground = Black)
    }

    public actual fun e(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Red)
        Background -> print(tag = tag, message = message, level = Verbose, background = RedBG, foreground = Black)
    }

    public actual fun c(
        tag: String?,
        message: Any,
        backgroundColor: LoggerBackgroundColor,
        foregroundColor: LoggerForegroundColor,
    ): Unit = print(
        tag = tag,
        message = message,
        level = Verbose,
        background = backgroundColor,
        foreground = foregroundColor
    )
}
