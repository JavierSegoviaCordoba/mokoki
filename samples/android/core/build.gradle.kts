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
}

dependencies {
    implementation(projects.mokokiCore)
    implementation(projects.mokokiSerialization)

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.2")
}
