hubdle {
    config {
        analysis()
        coverage()
        documentation { //
            api()
        }
        explicitApi()
        projectConfig { //
            generateProjectData(true)
        }
        publishing()
    }

    gradle {
        plugin {
            gradlePlugin {
                plugins {
                    create("mokoki") {
                        id = "com.javiersc.mokoki"
                        displayName = "Mokoki"
                        description = "Kotlin Compile time logger"
                        implementationClass =
                            "com.javiersc.mokoki.gradle.plugin.MokokiGradlePlugin"
                        tags.set(
                            listOf(
                                "mokoki",
                                "logger",
                                "kotlin",
                                "compile time",
                            )
                        )
                    }
                }
            }
        }
    }

    kotlin {
        jvm {
            main { //
                dependencies { //
                    compileOnly(projects.mokokiCompiler)
                    compileOnly(hubdle.jetbrains.kotlin.gradle.plugin.api)
                }
            }
        }
    }
}
