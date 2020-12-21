import com.javiersc.logger.Log
import com.javiersc.logger.LoggerBackgroundColor
import com.javiersc.logger.LoggerForegroundColor
import com.javiersc.logger.LoggerSeparator
import com.javiersc.logger.Mode
import com.javiersc.logger.extensions.logC
import com.javiersc.logger.extensions.logD
import com.javiersc.logger.extensions.logE
import com.javiersc.logger.extensions.logI
import com.javiersc.logger.extensions.logS
import com.javiersc.logger.extensions.logV
import com.javiersc.logger.extensions.logW

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
        logS("SomeTag", "Unlucky bug")
        logI("SomeTag", "Unlucky bug")
        logW("SomeTag", "Unlucky bug")
        logE("SomeTag", "Unlucky bug")
        logC("SomeTag", "Unlucky bug", LoggerBackgroundColor.Yellow, LoggerForegroundColor.BrightBlue)

        Log.mode = Mode.Background

        logV("Example without TAG")
        logD("Example without TAG")
        logS("Example without TAG")
        logI("Example without TAG")
        logW("Example without TAG")
        logE("Example without TAG")

        Log.isEnabled = false.also { println("isEnabled = false") }

        logV("This example should not appear")

        Log.isEnabled = true.also { println("isEnabled = true") }

        Log.mode = Mode.Normal

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
