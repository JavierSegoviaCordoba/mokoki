plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    kotlin {
        jvm {
            application {
                mainClass.set("com.javiersc.mokoki.jvm.core.MainKt")
            }
            main {
                dependencies {
                    implementation(projects.mokoki)
                }
            }
        }
    }
}
