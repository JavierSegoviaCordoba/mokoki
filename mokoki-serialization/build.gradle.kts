plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        languageSettings {
            optIn("kotlinx.serialization.ExperimentalSerializationApi")
        }
        publishing()
    }
    kotlin {
        multiplatform {
            features {
                serialization()
            }

            common {
                main {
                    dependencies {
                        api(projects.mokokiCore)
                    }
                }
                test {
                    dependencies {
                        implementation(projects.mokokiTest)
                    }
                }
            }

            android()
            ios()
            iosArm64()
            iosSimulatorArm64()
            iosX64()
            jvm()
        }
    }
}
