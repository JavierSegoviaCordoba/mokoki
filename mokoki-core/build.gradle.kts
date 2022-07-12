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
            jvmAndAndroid()
        }
    }
}
