val commonDependencies get() = Dependencies.Common
val commonTestDependencies get() = Dependencies.CommonTest
val jvmDependencies get() = Dependencies.Jvm
val jvmTestDependencies get() = Dependencies.JvmTest

object Dependencies {

    object Common {
        val kotlinSerializationJson = kotlinx("serialization-json:${versions.serialization}")
    }

    object CommonTest

    object Jvm

    object JvmTest

    object Plugins {
        const val dependencyUpdates = "com.github.ben-manes:gradle-versions-plugin:${versions.dependencyUpdates}"
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${versions.detekt}"
        const val dokka = "org.jetbrains.dokka:dokka-gradle-plugin:${versions.dokka}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${versions.kotlin}"
        const val nexusStaging = "io.codearte.gradle.nexus:gradle-nexus-staging-plugin:${versions.nexusStaging}"
        const val nexusPublish = "de.marcphilipp.gradle:nexus-publish-plugin:${versions.nexusPublish}"
    }

    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${versions.detekt}"
}

private fun kotlin(dependency: String) = "org.jetbrains.kotlin:kotlin-$dependency"
private fun kotlinx(dependency: String) = "org.jetbrains.kotlinx:kotlinx-$dependency"
