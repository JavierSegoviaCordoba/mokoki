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
            common()

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
