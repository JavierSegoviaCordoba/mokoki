plugins {
    KotlinMultiplatform
    JaCoCo
    MavenPublish
    Nexus
    Dokka
}

val loggerVersion: String by project
val isLoggerReleaseEnv: Boolean? = System.getenv("isLoggerReleaseEnv")?.toBoolean()
val isLoggerRelease: String by project

val finalVersion = loggerVersion.generateVersion(isLoggerReleaseEnv ?: isLoggerRelease.toBoolean())

group = "com.javiersc.logger"
version = finalVersion

 val dokkaJar by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
    dependsOn(tasks.dokkaHtml)
    dependsOn(tasks.dokkaJavadoc)
 }

kotlin {
    explicitApi()

    jvm {
        mavenPublication {
            artifact(dokkaJar)
        }
    }

    sourceSets {
        named("commonMain") { }

        named("jvmMain") { }

        all {
            languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
        }
    }
}
