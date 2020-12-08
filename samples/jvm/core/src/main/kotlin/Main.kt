package com.javiersc.logger.samples.jvm.core

import com.javiersc.logger.core.Logger
import com.javiersc.logger.core.Mode
import com.javiersc.logger.core.extensions.logD
import com.javiersc.logger.core.extensions.logE
import com.javiersc.logger.core.extensions.logI
import com.javiersc.logger.core.extensions.logV
import com.javiersc.logger.core.extensions.logW

fun main() {
    App()
}

class App {

    init {
        showColors()
    }

    private fun showColors() {
        Logger.apply {
            mode = Mode.Normal
        }

        logV("SomeTag", "Unlucky bug")
        logD("SomeTag", "Unlucky bug")
        logI("SomeTag", "Unlucky bug")
        logW("SomeTag", "Unlucky bug")
        logE("SomeTag", "Unlucky bug")

        Logger.apply {
            mode = Mode.Background
        }

        logV("Example without TAG")
        logD("Example without TAG")
        logI("Example without TAG")
        logW("Example without TAG")
        logE("Example without TAG")
    }
}
