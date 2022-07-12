plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    kotlin {
        android {
            application {
                features {
                    serialization()
                }
                main {
                    dependencies {
                        implementation(androidxAppcompat())
                        implementation(androidxCoreKtx())

                        implementation(projects.mokokiCore)
                        implementation(projects.mokokiSerialization)
                    }
                }
            }
        }
    }
}
