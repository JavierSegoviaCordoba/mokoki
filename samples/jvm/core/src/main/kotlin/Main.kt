package com.javiersc.mokoki

import com.javiersc.mokoki.extensions.logD
import com.javiersc.mokoki.extensions.logE
import com.javiersc.mokoki.extensions.logI
import com.javiersc.mokoki.extensions.logV
import com.javiersc.mokoki.extensions.logW
import java.util.logging.Logger

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    Mokoki.init(MokokiLogger())
    App()
}

class App {

    init {
        showColors()
    }

    private fun showColors() {
        Mokoki.isEnabled = true

        logV("SomeTag", "Unlucky bug")
        logD("SomeTag", "Unlucky bug")
        logI("SomeTag", "Unlucky bug")
        logW("SomeTag", "Unlucky bug")
        logE("SomeTag", "Unlucky bug")

        Logger.getGlobal().info("------------------------------------------------------------")

        logV("Example without TAG")
        logD("Example without TAG")
        logI("Example without TAG")
        logW("Example without TAG")
        logE("Example without TAG")

        Mokoki.isEnabled = false.also { Logger.getGlobal().info("isEnabled = false") }

        logV("This example should not appear")

        Mokoki.isEnabled = true.also { Logger.getGlobal().info("isEnabled = true") }

        val textWithSeparator =
            """
                |Text before first separator
                |$LoggerSeparator
                |Text after first separator and before last separator
                |$LoggerSeparator
                |Text after last separator
            """.trimMargin()
        logV(textWithSeparator)
    }
}
