package com.javiersc.logger.core

import com.javiersc.logger.core.Mode.Background
import com.javiersc.logger.core.Mode.Normal
import com.javiersc.logger.core.internal.Color.Black
import com.javiersc.logger.core.internal.Color.Blue
import com.javiersc.logger.core.internal.Color.BlueBG
import com.javiersc.logger.core.internal.Color.GrayBG
import com.javiersc.logger.core.internal.Color.Green
import com.javiersc.logger.core.internal.Color.GreenBG
import com.javiersc.logger.core.internal.Color.Red
import com.javiersc.logger.core.internal.Color.RedBG
import com.javiersc.logger.core.internal.Color.Yellow
import com.javiersc.logger.core.internal.Color.YellowBG
import com.javiersc.logger.core.internal.Level.Verbose
import com.javiersc.logger.core.internal.print

public actual object Logger : Log {

    public actual var mode: Mode = Normal

    override fun v(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose)
        Background -> print(tag = tag, message = message, level = Verbose, background = GrayBG, foreground = Black)
    }

    override fun d(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Green)
        Background -> print(tag = tag, message = message, level = Verbose, background = GreenBG, foreground = Black)
    }

    override fun i(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Blue)
        Background -> print(tag = tag, message = message, level = Verbose, background = BlueBG, foreground = Black)
    }

    override fun w(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Yellow)
        Background -> print(tag = tag, message = message, level = Verbose, background = YellowBG, foreground = Black)
    }

    override fun e(tag: String?, message: Any): Unit = when (mode) {
        Normal -> print(tag = tag, message = message, level = Verbose, foreground = Red)
        Background -> print(tag = tag, message = message, level = Verbose, background = RedBG, foreground = Black)
    }
}
