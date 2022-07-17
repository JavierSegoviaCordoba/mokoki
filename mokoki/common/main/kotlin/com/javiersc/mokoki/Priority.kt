@file:Suppress("MagicNumber")

package com.javiersc.mokoki

import com.javiersc.kotlin.stdlib.AnsiColor

public enum class Priority(private val value: Int) {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7);

    public val ansiColor: AnsiColor
        get() =
            when (this) {
                VERBOSE -> AnsiColor.Reset
                DEBUG -> AnsiColor.Foreground.BrightGreen
                INFO -> AnsiColor.Foreground.BrightYellow
                WARN -> AnsiColor.Foreground.Yellow
                ERROR -> AnsiColor.Foreground.BrightRed
                ASSERT -> AnsiColor.Foreground.Red
            }

    public fun isLoggable(other: Priority): Boolean = this.value >= other.value
}
