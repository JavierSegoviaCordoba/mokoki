@file:Suppress("MagicNumber")

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    compileSdkVersion(30)

    defaultConfig { minSdkVersion(21) }
}

dependencies {
    implementation(projects.mokoki)
    implementation(projects.mokokiSerialization)

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.2")
}
