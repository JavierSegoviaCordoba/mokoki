@file:Suppress("MaxLineLength")

package com.javiersc.mokoki

import com.javiersc.kotlin.test.IgnoreDARWIN
import com.javiersc.kotlin.test.IgnoreMINGW
import com.javiersc.mokoki.test.internal.lineNumberForTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@IgnoreMINGW
internal class MokokiTest {

    private val testLogger = TestMokokiLogger(minPriority = Priority.VERBOSE)

    @BeforeTest
    fun install_logger() {
        MokokiLogger.install(testLogger)
    }

    @AfterTest
    fun uninstallAllLoggers() {
        MokokiLogger.uninstallAllLoggers()
    }

    @Test
    fun log_V() {
        logV("Some tag") { "Some message" }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
               ┌─────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ VERBOSE.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_V │ line $n │
               ├─────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                        │ 
               └─────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_D() {
        logD("Some tag") { "Some message" }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
               ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ DEBUG.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_D │ line $n │
               ├───────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                      │ 
               └───────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_I() {
        logI("Some tag") { "Some message" }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ INFO.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_I │ line $n │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                     │ 
               └──────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_W() {
        logW("Some tag") { "Some message" }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ WARN.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_W │ line $n │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                     │ 
               └──────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_E() {
        logE("Some tag") { "Some message" }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
               ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ ERROR.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_E │ line $n │
               ├───────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                      │ 
               └───────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_WTF() {
        logWTF("Some tag") { "Some message" }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
               ┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ ASSERT.(MokokiTest.kt:$nu) │ file MokokiTest.kt │ class MokokiTest │ fun log_WTF │ line $nu │
               ├────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                           │ 
               └────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @IgnoreDARWIN
    @Test
    fun log_some_throwable() {
        logE("Some tag") { IllegalStateException("Some message") }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assertContains(
            """
                ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
                │ Some tag │ ERROR.(MokokiTest.kt:$nu) │ file MokokiTest.kt │ class MokokiTest │ fun log_some_throwable │ line $nu                          │
                ├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
                │ java.lang.IllegalStateException: Some message                                                                                             │
            """
                .trimIndent(),
        )
    }
}
