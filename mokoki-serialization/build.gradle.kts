plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        languageSettings {
            experimentalSerializationApi()
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
                        api(projects.mokoki)
                    }
                }
                test {
                    dependencies {
                        implementation(projects.mokokiTest)
                    }
                }
            }

            android()

            darwin {
                enableAll()
            }

            jvm()
            jvmAndAndroid()

            mingw {
                enableAll()
            }
        }
    }
}
