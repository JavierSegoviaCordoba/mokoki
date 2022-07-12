@file:Suppress("MaxLineLength")

package com.javiersc.mokoki

import com.javiersc.mokoki.test.internal.lineNumberForTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

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
        val n = lineNumberForTest
        logV("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌─────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ VERBOSE.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_V │ line $n │
               ├─────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                        │ 
               └─────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }

    @Test
    fun log_D() {
        val n = lineNumberForTest
        logD("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ DEBUG.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_D │ line $n │
               ├───────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                      │ 
               └───────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }

    @Test
    fun log_I() {
        val n = lineNumberForTest
        logI("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ INFO.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_I │ line $n │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                     │ 
               └──────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }

    @Test
    fun log_W() {
        val n = lineNumberForTest
        logW("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ WARN.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_W │ line $n │
               ├──────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                     │ 
               └──────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }

    @Test
    fun log_E() {
        val n = lineNumberForTest
        logE("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ ERROR.(MokokiTest.kt:$n) │ file MokokiTest.kt │ class MokokiTest │ fun log_E │ line $n │
               ├───────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                      │ 
               └───────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }
    @Test
    fun log_WTF() {
        val nu = lineNumberForTest
        logWTF("Some tag") { "Some message" }

        testLogger.assert(
            """
               ┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
               │ Some tag │ ASSERT.(MokokiTest.kt:$nu) │ file MokokiTest.kt │ class MokokiTest │ fun log_WTF │ line $nu │
               ├────────────────────────────────────────────────────────────────────────────────────────────────────────┤
               │ Some message                                                                                           │ 
               └────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }

    @Test
    fun log_some_throwable() {
        val nu = lineNumberForTest
        logE("Some tag") { IllegalStateException("Some message") }

        testLogger.assert(
            """
                ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
                │ Some tag │ ERROR.(MokokiTest.kt:$nu) │ file MokokiTest.kt │ class MokokiTest │ fun log_some_throwable │ line $nu                          │
                ├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤
                │ java.lang.IllegalStateException: Some message                                                                                             │
                │ 	at com.javiersc.mokoki.MokokiTest.log_some_throwable(MokokiTest.kt:$nu)                                                                  │
                │ 	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)                                 │
                │ 	at java.base/java.lang.reflect.Method.invoke(Method.java:577)                                                                            │
                │ 	at org.junit.runners.model.FrameworkMethod${'$'}1.runReflectiveCall(FrameworkMethod.java:59)                                                  │
                │ 	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)                                                   │
                │ 	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)                                                    │
                │ 	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)                                                     │
                │ 	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)                                                         │
                │ 	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)                                                           │
                │ 	at org.junit.runners.ParentRunner${'$'}3.evaluate(ParentRunner.java:306)                                                                      │
                │ 	at org.junit.runners.BlockJUnit4ClassRunner${'$'}1.evaluate(BlockJUnit4ClassRunner.java:100)                                                  │
                │ 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:366)                                                                         │
                │ 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:103)                                                    │
                │ 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:63)                                                     │
                │ 	at org.junit.runners.ParentRunner${'$'}4.run(ParentRunner.java:331)                                                                           │
                │ 	at org.junit.runners.ParentRunner${'$'}1.schedule(ParentRunner.java:79)                                                                       │
                │ 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)                                                                     │
                │ 	at org.junit.runners.ParentRunner.access${'$'}100(ParentRunner.java:66)                                                                       │
                │ 	at org.junit.runners.ParentRunner${'$'}2.evaluate(ParentRunner.java:293)                                                                      │
                │ 	at org.junit.runners.ParentRunner${'$'}3.evaluate(ParentRunner.java:306)                                                                      │
                │ 	at org.junit.runners.ParentRunner.run(ParentRunner.java:413)                                                                             │
                │ 	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.runTestClass(JUnitTestClassExecutor.java:110)                      │
                │ 	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:58)                            │
                │ 	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:38)                            │
                │ 	at org.gradle.api.internal.tasks.testing.junit.AbstractJUnitTestClassProcessor.processTestClass(AbstractJUnitTestClassProcessor.java:62) │
                │ 	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:51)                       │
                │ 	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)                                 │
                │ 	at java.base/java.lang.reflect.Method.invoke(Method.java:577)                                                                            │
                │ 	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)                                                  │
                │ 	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)                                                  │
                │ 	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)                                  │
                │ 	at org.gradle.internal.dispatch.ProxyDispatchAdapter${'$'}DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)                   │
                │ 	at jdk.proxy1/jdk.proxy1.${'$'}Proxy2.processTestClass(Unknown Source)                                                                        │
                │ 	at org.gradle.api.internal.tasks.testing.worker.TestWorker${'$'}2.run(TestWorker.java:176)                                                    │
                │ 	at org.gradle.api.internal.tasks.testing.worker.TestWorker.executeAndMaintainThreadName(TestWorker.java:129)                             │
                │ 	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:100)                                                  │
                │ 	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:60)                                                   │
                │ 	at org.gradle.process.internal.worker.child.ActionExecutionWorker.execute(ActionExecutionWorker.java:56)                                 │
                │ 	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:133)         │
                │ 	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:71)          │
                │ 	at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:69)                                              │
                │ 	at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:74)                                             │
                │                                                                                                                                           │
                └───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
            """.trimIndent()
        )
    }
}
