
rootProject.name = "logger"

enableFeaturePreview("GRADLE_METADATA")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
    }
}

/** Libraries */
include(":logger-core")
include(":logger-serialization")

/** Docs */
include(":docs")

/** Samples */
include(":samples:jvm:core")
include(":samples:jvm:serialization")
