plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        publishing()
    }
    kotlin {
        multiplatform {
            common {
                test {
                    dependencies {
                        implementation(javierscKotlinStdlib())
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
