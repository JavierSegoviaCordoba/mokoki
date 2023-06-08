package com.javiersc.mokoki.compiler

import com.javiersc.mokoki.mokoki.compiler.MokokiCompilerProjectData
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor

public class MokokiCommandLineProcessor : CommandLineProcessor {

    override val pluginId: String =
        "${MokokiCompilerProjectData.Group}.${MokokiCompilerProjectData.Name}"

    override val pluginOptions: Collection<AbstractCliOption> = emptyList()
}
