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
        commonMain {
            dependencies {
                projects.apply {
                    api(loggerCore)
                }

                libs.common.main.apply{
                    api(serialization.json)
                }
            }
        }

        defaultLanguageSettings
    }
}
