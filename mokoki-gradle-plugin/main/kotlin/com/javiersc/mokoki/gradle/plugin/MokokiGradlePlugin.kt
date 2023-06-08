package com.javiersc.mokoki.gradle.plugin

import com.javiersc.mokoki.mokoki.compiler.MokokiCompilerProjectData
import javax.inject.Inject
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

public class MokokiGradlePlugin @Inject constructor(private val providers: ProviderFactory) :
    KotlinCompilerPluginSupportPlugin {

    override fun apply(target: Project) {
        // TODO: Add the dependency to the project
    }

    override fun applyToCompilation(
        kotlinCompilation: KotlinCompilation<*>
    ): Provider<List<SubpluginOption>> = providers.provider { emptyList() }

    override fun getCompilerPluginId(): String =
        "${MokokiCompilerProjectData.Group}.${MokokiCompilerProjectData.Name}"

    override fun getPluginArtifact(): SubpluginArtifact =
        SubpluginArtifact(
            groupId = MokokiCompilerProjectData.Group,
            artifactId = MokokiCompilerProjectData.Name,
            version = MokokiCompilerProjectData.Version,
        )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean = true
}
