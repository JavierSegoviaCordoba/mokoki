@file:OptIn(ExperimentalCompilerApi::class)

package com.javiersc.mokoki.compiler

import com.javiersc.kotlin.compiler.test.generateKotlinCompilerTests
import com.javiersc.kotlin.compiler.test.runners.BoxTest
import com.javiersc.kotlin.compiler.test.runners.DiagnosticTest
import com.javiersc.kotlin.compiler.test.services.MetaRuntimeClasspathProvider
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar.ExtensionStorage
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.test.Constructor
import org.jetbrains.kotlin.test.model.TestModule

fun main() {
    generateKotlinCompilerTests<AbstractDiagnosticTest, AbstractBoxTest>()
}

fun ExtensionStorage.allExtensions(module: TestModule, configuration: CompilerConfiguration) {
    IrGenerationExtension.registerExtension(IrMokokiExtension())
}

open class AbstractDiagnosticTest : DiagnosticTest() {

    override fun ExtensionStorage.registerExtensions(
        module: TestModule,
        configuration: CompilerConfiguration,
    ) {
        allExtensions(module, configuration)
    }
}

open class AbstractBoxTest : BoxTest() {

    override val runtimeClasspathProvider: Constructor<MetaRuntimeClasspathProvider> =
        ::GeneratedMetaRuntimeClasspathProvider

    override fun ExtensionStorage.registerExtensions(
        module: TestModule,
        configuration: CompilerConfiguration,
    ) {
        allExtensions(module, configuration)
    }
}
