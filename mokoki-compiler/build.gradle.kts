hubdle {
    config {
        analysis()
        coverage()
        documentation { //
            api()
        }
        explicitApi()
        projectConfig()
        publishing()
    }
    kotlin {
        jvm {
            features { //
                compiler {
                    mainClass.set("com.javiersc.mokoki.compiler.GenerateKotlinCompilerTestsKt")
                    generateTestOnSync(false)
                    testDependencies(hubdle.javiersc.kotlin.kotlinStdlib)
                    testProjects(projects.mokoki)
                }
            }
            main { //
                dependencies { //
                    implementation(projects.mokoki)
                }
            }
        }
    }
}
