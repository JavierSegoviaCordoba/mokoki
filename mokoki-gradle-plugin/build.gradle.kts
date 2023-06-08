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
    kotlin {
        jvm {
            features {
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
            }

            main { //
                dependencies { //
                    compileOnly(projects.mokokiCompiler)
                    compileOnly(hubdle.jetbrains.kotlin.gradle.plugin.api)
                }
            }
        }
    }
}
