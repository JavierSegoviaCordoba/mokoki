rootProject.name = providers.gradleProperty("allProjects.name").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    plugins {
        val buildVersionCatalogs: String by settings

        id("com.javiersc.gradle.plugins.build.version.catalogs") version buildVersionCatalogs
    }
}

plugins {
    id("com.javiersc.gradle.plugins.build.version.catalogs")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

include(
    ":a--catalogs:libs",
    ":a--catalogs:plugins",
)

include(
    ":mokoki-core",
    ":mokoki-serialization",
)

include(
    ":samples:android:android-core",
    ":samples:jvm:jvm-core",
    ":samples:jvm:jvm-serialization",
)
