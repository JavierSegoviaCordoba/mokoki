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
