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

    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${versions.detekt}"
}

private fun kotlin(dependency: String) = "org.jetbrains.kotlin:kotlin-$dependency"
private fun kotlinx(dependency: String) = "org.jetbrains.kotlinx:kotlinx-$dependency"
