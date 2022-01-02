package com.javiersc.mokoki

import com.javiersc.mokoki.internal.Level
import com.javiersc.mokoki.internal.buildMokokiMessage
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

class MokokiTest {

    @Test
    fun test_mokoki() {
        val expect = MokokiLogger().buildMokokiMessage("Some tag", "Some message", Level.Verbose)

        expect[0].shouldContain("┌─────────────────────────────")
        expect[1].shouldContain("│ Some tag")
        expect[1].shouldContain("│ Verbose.(Thread.java:")
        expect[1].shouldContain("│ fun getStackTrace")
        expect[2].shouldContain("├─────────────────────────────")
        expect[3].shouldContain("│ Some message")
        expect[4].shouldContain("└─────────────────────────────")
    }
}
