package com.javiersc.mokoki.jvm.core

import com.javiersc.mokoki.LoggerSeparator
import com.javiersc.mokoki.MokokiLogger
import com.javiersc.mokoki.PrintMokokiLogger
import com.javiersc.mokoki.Priority
import com.javiersc.mokoki.logD
import com.javiersc.mokoki.logE
import com.javiersc.mokoki.logI
import com.javiersc.mokoki.logV
import com.javiersc.mokoki.logW
import com.javiersc.mokoki.logWTF

fun main() {
    App(false)
    println("    ")
    println("------------------------------------------------------------")
    println("------------------------------------------------------------")
    println("    ")
    App(true)
}

class App(useCompatibleMode: Boolean) {

    init {
        showColors(useCompatibleMode)
    }

    private fun showColors(useCompatibleMode: Boolean) {
        MokokiLogger.uninstallAllLoggers()
        val printLogger =
            PrintMokokiLogger(minPriority = Priority.VERBOSE).apply {
                this.useCompatibleMode = useCompatibleMode
            }
        MokokiLogger.install(printLogger)

        logV("SomeTag") { "Unlucky bug" }
        logD("SomeTag") { "Unlucky bug" }
        logI("SomeTag") { "Unlucky bug" }
        logW("SomeTag") { "Unlucky bug" }
        logE("SomeTag") { "Unlucky bug" }
        logWTF("SomeTag") { "Unlucky bug" }

        println("")
        println(" ------------------------------------------------------------")
        println("")

        logV { "Example without TAG" }
        logD { "Example without TAG" }
        logI { "Example without TAG" }
        logW { "Example without TAG" }
        logE { "Example without TAG" }
        logWTF { "Example without TAG" }

        val textWithSeparator =
            """
                Text before first separator
                ${LoggerSeparator(useCompatibleMode)}
                Text after first separator and before last separator
                ${LoggerSeparator(useCompatibleMode)}
                Text after last separator
            """.trimIndent()
        logV { textWithSeparator }
    }
}
