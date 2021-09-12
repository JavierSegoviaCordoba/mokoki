rootProject.name = providers.gradleProperty("allProjects.name").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") { from(files("gradle/libs.toml")) }
        create("pluginLibs") { from(files("gradle/pluginLibs.toml")) }
    }
}

include(
    ":mokoki-core",
    ":mokoki-serialization",
)

include(
    ":samples:android:android-core",
    ":samples:jvm:jvm-core",
    ":samples:jvm:jvm-serialization",
)
