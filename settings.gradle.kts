dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
    }
}

rootProject.name = "logger"

enableFeaturePreview("GRADLE_METADATA")

/** Libraries */
include(":logger-core")
include(":logger-serialization")

/** Docs */
include(":docs")

/** Samples */
include(":samples:jvm:core")
include(":samples:jvm:serialization")
