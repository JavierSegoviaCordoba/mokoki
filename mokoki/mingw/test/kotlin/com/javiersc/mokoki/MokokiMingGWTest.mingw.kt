@file:Suppress("MaxLineLength")

package com.javiersc.mokoki

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class MokokiMingGWTest {

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

        testLogger.assert(
            """
               ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ VERBOSE.(MokokiMingGWTest.kt:1) │ file MokokiMingGWTest.kt │ class MokokiMingGWTest │ fun log_V │ line 1 │
               ├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                                        │
               └─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_D() {
        logD("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ DEBUG.(MokokiMingGWTest.kt:1) │ file MokokiMingGWTest.kt │ class MokokiMingGWTest │ fun log_D │ line 1 │
               ├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                                      │
               └───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_I() {
        logI("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ INFO.(MokokiMingGWTest.kt:1) │ file MokokiMingGWTest.kt │ class MokokiMingGWTest │ fun log_I │ line 1 │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                                     │
               └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_W() {
        logW("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ WARN.(MokokiMingGWTest.kt:1) │ file MokokiMingGWTest.kt │ class MokokiMingGWTest │ fun log_W │ line 1 │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                                     │
               └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_E() {
        logE("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ ERROR.(MokokiMingGWTest.kt:1) │ file MokokiMingGWTest.kt │ class MokokiMingGWTest │ fun log_E │ line 1 │
               ├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                                      │
               └───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }

    @Test
    fun log_WTF() {
        logWTF("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ ASSERT.(MokokiMingGWTest.kt:1) │ file MokokiMingGWTest.kt │ class MokokiMingGWTest │ fun log_WTF │ line 1 │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                                         │
               └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """
                .trimIndent(),
        )
    }
}
