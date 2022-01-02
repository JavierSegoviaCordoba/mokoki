rootProject.name = providers.gradleProperty("project.name").forUseAtConfigurationTime().get()

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

file("local.properties").apply {
    if (exists().not()) {
        createNewFile()
        writeText("samples.enabled=false")
    }
    inputStream().use { fileInputStream ->
        java.util.Properties().apply {
            load(fileInputStream)
            if (getProperty("samples.enabled")?.toString()?.toBoolean() == true) {
                include(
                    ":samples:android:android-core",
                    ":samples:jvm:jvm-core",
                    ":samples:jvm:jvm-serialization",
                )
            }
        }
    }
}
