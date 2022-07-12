plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    kotlin {
        jvm {
            application {
                mainClass.set("com.javiersc.mokoki.jvm.serialization.MainKt")
            }
            features {
                serialization()
            }
            main {
                dependencies {
                    implementation(projects.mokokiSerialization)
                }
            }
        }
    }
}
