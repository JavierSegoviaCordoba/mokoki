plugins {
    KotlinMultiplatform
    JaCoCo
    NexusPublish
    Dokka
    LoggerVersioning
}

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
        named("commonMain") {
            dependencies {
                api(project(":logger-core"))
                api(commonDependencies.kotlinSerializationJson)
            }
        }

        defaultLanguageSettings
    }
}
