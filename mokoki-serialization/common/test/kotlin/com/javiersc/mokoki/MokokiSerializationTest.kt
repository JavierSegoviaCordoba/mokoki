@file:Suppress("MaxLineLength")

package com.javiersc.mokoki

import com.javiersc.kotlin.test.IgnoreMINGW
import com.javiersc.mokoki.test.internal.lineNumberForTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlinx.serialization.Serializable

@IgnoreMINGW
internal class MokokiSerializationTest {

    private val testLogger = TestMokokiSerializationLogger(minPriority = Priority.VERBOSE)

    @BeforeTest
    fun install_logger() {
        MokokiLogger.install(testLogger)
    }

    @AfterTest
    fun uninstallAllLoggers() {
        MokokiLogger.uninstallAllLoggers()
    }

    @Test
    fun json_log_V() {
        logV("Some tag") { userString }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ VERBOSE.(MokokiSerializationTest.kt:$n) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun json_log_V │ line $n │ 
                ├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                               │ 
                │     "name": "Mike",                                                                                                                             │ 
                │     "age": 22,                                                                                                                                  │ 
                │     "hobbies": [                                                                                                                                │ 
                │         "Football",                                                                                                                             │ 
                │         "Reading"                                                                                                                               │ 
                │     ]                                                                                                                                           │ 
                │ }                                                                                                                                               │ 
                └─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun json_log_D() {
        logD("Some tag") { userString }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ DEBUG.(MokokiSerializationTest.kt:$n) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun json_log_D │ line $n │ 
                ├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                             │ 
                │     "name": "Mike",                                                                                                                           │ 
                │     "age": 22,                                                                                                                                │ 
                │     "hobbies": [                                                                                                                              │ 
                │         "Football",                                                                                                                           │ 
                │         "Reading"                                                                                                                             │ 
                │     ]                                                                                                                                         │ 
                │ }                                                                                                                                             │ 
                └───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun json_log_I() {
        logI("Some tag") { userString }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ INFO.(MokokiSerializationTest.kt:$n) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun json_log_I │ line $n │ 
                ├──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                            │ 
                │     "name": "Mike",                                                                                                                          │ 
                │     "age": 22,                                                                                                                               │ 
                │     "hobbies": [                                                                                                                             │ 
                │         "Football",                                                                                                                          │ 
                │         "Reading"                                                                                                                            │ 
                │     ]                                                                                                                                        │ 
                │ }                                                                                                                                            │ 
                └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun json_log_W() {
        logW("Some tag") { userString }
        val n = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ WARN.(MokokiSerializationTest.kt:$n) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun json_log_W │ line $n │ 
                ├──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                            │ 
                │     "name": "Mike",                                                                                                                          │ 
                │     "age": 22,                                                                                                                               │ 
                │     "hobbies": [                                                                                                                             │ 
                │         "Football",                                                                                                                          │ 
                │         "Reading"                                                                                                                            │ 
                │     ]                                                                                                                                        │ 
                │ }                                                                                                                                            │ 
                └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun json_log_E() {
        logE("Some tag") { userString }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ ERROR.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun json_log_E │ line $nu │ 
                ├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                               │ 
                │     "name": "Mike",                                                                                                                             │ 
                │     "age": 22,                                                                                                                                  │ 
                │     "hobbies": [                                                                                                                                │ 
                │         "Football",                                                                                                                             │ 
                │         "Reading"                                                                                                                               │ 
                │     ]                                                                                                                                           │ 
                │ }                                                                                                                                               │ 
                └─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun json_log_WTF() {
        logWTF("Some tag") { userString }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ ASSERT.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun json_log_WTF │ line $nu │ 
                ├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                  │ 
                │     "name": "Mike",                                                                                                                                │ 
                │     "age": 22,                                                                                                                                     │ 
                │     "hobbies": [                                                                                                                                   │ 
                │         "Football",                                                                                                                                │ 
                │         "Reading"                                                                                                                                  │ 
                │     ]                                                                                                                                              │ 
                │ }                                                                                                                                                  │ 
                └────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun serializable_log_V() {
        logV("Some tag") { user }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ VERBOSE.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun serializable_log_V │ line $nu │ 
                ├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                         │ 
                │     "name": "John",                                                                                                                                       │ 
                │     "age": 19,                                                                                                                                            │ 
                │     "hobbies": [                                                                                                                                          │ 
                │         "Tennis",                                                                                                                                         │ 
                │         "Coding"                                                                                                                                          │ 
                │     ]                                                                                                                                                     │ 
                │ }                                                                                                                                                         │ 
                └───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun serializable_log_D() {
        logD("Some tag") { user }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ DEBUG.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun serializable_log_D │ line $nu │ 
                ├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                       │ 
                │     "name": "John",                                                                                                                                     │ 
                │     "age": 19,                                                                                                                                          │ 
                │     "hobbies": [                                                                                                                                        │ 
                │         "Tennis",                                                                                                                                       │ 
                │         "Coding"                                                                                                                                        │ 
                │     ]                                                                                                                                                   │ 
                │ }                                                                                                                                                       │ 
                └─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun serializable_log_I() {
        logI("Some tag") { user }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ INFO.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun serializable_log_I │ line $nu │ 
                ├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                      │ 
                │     "name": "John",                                                                                                                                    │ 
                │     "age": 19,                                                                                                                                         │ 
                │     "hobbies": [                                                                                                                                       │ 
                │         "Tennis",                                                                                                                                      │ 
                │         "Coding"                                                                                                                                       │ 
                │     ]                                                                                                                                                  │ 
                │ }                                                                                                                                                      │ 
                └────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun serializable_log_W() {
        logW("Some tag") { user }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ WARN.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun serializable_log_W │ line $nu │ 
                ├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                      │ 
                │     "name": "John",                                                                                                                                    │ 
                │     "age": 19,                                                                                                                                         │ 
                │     "hobbies": [                                                                                                                                       │ 
                │         "Tennis",                                                                                                                                      │ 
                │         "Coding"                                                                                                                                       │ 
                │     ]                                                                                                                                                  │ 
                │ }                                                                                                                                                      │ 
                └────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun serializable_log_E() {
        logE("Some tag") { user }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ ERROR.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun serializable_log_E │ line $nu │ 
                ├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                       │ 
                │     "name": "John",                                                                                                                                     │ 
                │     "age": 19,                                                                                                                                          │ 
                │     "hobbies": [                                                                                                                                        │ 
                │         "Tennis",                                                                                                                                       │ 
                │         "Coding"                                                                                                                                        │ 
                │     ]                                                                                                                                                   │ 
                │ }                                                                                                                                                       │ 
                └─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }

    @Test
    fun serializable_log_WTF() {
        logWTF("Some tag") { user }
        val nu = testLogger.lastMessage.lineNumberForTest

        testLogger.assert(
            """
                ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ 
                │ Some tag │ ASSERT.(MokokiSerializationTest.kt:$nu) │ file MokokiSerializationTest.kt │ class MokokiSerializationTest │ fun serializable_log_WTF │ line $nu │ 
                ├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤ 
                │ {                                                                                                                                                          │ 
                │     "name": "John",                                                                                                                                        │ 
                │     "age": 19,                                                                                                                                             │ 
                │     "hobbies": [                                                                                                                                           │ 
                │         "Tennis",                                                                                                                                          │ 
                │         "Coding"                                                                                                                                           │ 
                │     ]                                                                                                                                                      │ 
                │ }                                                                                                                                                          │ 
                └────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ 
            """.trimIndent()
        )
    }
}

@Serializable private data class User(val name: String, val age: Int, val hobbies: List<String>)

private val user = User("John", 19, listOf("Tennis", "Coding"))

private val userString =
    """
       | {
       |    "name": "Mike",
       |    "age": 22,
       |    "hobbies": ["Football", "Reading"]
       | }
    """.trimMargin()
