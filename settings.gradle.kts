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
include(":logger")
include(":logger-serialization")

/** Samples */
include(":samples:jvm:core")
include(":samples:jvm:serialization")
