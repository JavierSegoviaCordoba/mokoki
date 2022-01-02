plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    implementation(files(pluginLibs.javaClass.protectionDomain.codeSource.location))

    pluginLibs.apply {
        implementation(android.toolsBuild.gradle)
        implementation(javiersc.gradlePlugins.allPlugins)
        implementation(jetbrains.kotlin.kotlinGradlePlugin)
        implementation(jetbrains.kotlin.kotlinSerialization)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
