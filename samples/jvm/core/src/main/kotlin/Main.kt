package com.javiersc.logger.samples.jvm.core

import com.javiersc.logger.core.Log
import com.javiersc.logger.core.LoggerBackgroundColor
import com.javiersc.logger.core.LoggerForegroundColor
import com.javiersc.logger.core.Mode
import com.javiersc.logger.core.extensions.logC
import com.javiersc.logger.core.extensions.logD
import com.javiersc.logger.core.extensions.logE
import com.javiersc.logger.core.extensions.logI
import com.javiersc.logger.core.extensions.logV
import com.javiersc.logger.core.extensions.logW
import com.javiersc.logger.core.internal.Separator
import com.javiersc.logger.core.internal.SeparatorSymbolStart

fun main() {
    App()
}

class App {

    init {
        showColors()
    }

    private fun showColors() {
        Log.mode = Mode.Normal

        logV("SomeTag", "Unlucky bug")
        logD("SomeTag", "Unlucky bug")
        logI("SomeTag", "Unlucky bug")
        logW("SomeTag", "Unlucky bug")
        logE("SomeTag", "Unlucky bug")
        logC("SomeTag", "Unlucky bug", LoggerBackgroundColor.Yellow, LoggerForegroundColor.BrightBlue)

        Log.mode = Mode.Background

        logV("Example without TAG")
        logD("Example without TAG")
        logI("Example without TAG")
        logW("Example without TAG")
        logE("Example without TAG")

        Log.isEnabled = false.also { println("isEnabled = false") }

        logV("This example should not appear")

        Log.isEnabled = true.also { println("isEnabled = true") }

        Log.mode = Mode.Normal

        val textWithSeparator =
            """
                | Text before separator
                |$Separator
                | Text after separator
            """.trimMargin()
        logV(textWithSeparator)

        val textWithCustomSeparator =
            """
                | Text before separator
                |$SeparatorSymbolStart${"#".repeat(200)}
                | Text after separator
            """.trimMargin()
        logV(textWithCustomSeparator)
    }
}
