@file:Suppress("MagicNumber")

plugins {
    `android-application`
    `kotlin-android`
    `kotlinx-serialization`
    `javiersc-code-formatter`
}

android {
    compileSdkVersion(30)

    defaultConfig { minSdkVersion(21) }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(projects.mokokiCore)
    implementation(projects.mokokiSerialization)

    implementation(libs.androidx.appcompat.appcompat)
    implementation(libs.androidx.core.coreKtx)
}
