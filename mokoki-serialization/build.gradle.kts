@file:Suppress("MagicNumber")

plugins {
    `android-library`
    `javiersc-kotlin-multiplatform`
    `kotlinx-serialization`
    `javiersc-publish-kotlin-multiplatform`
}

android {
    compileSdkVersion(30)

    defaultConfig { minSdkVersion(21) }

    sourceSets.all { manifest.srcFile("src/android${name.capitalize()}/AndroidManifest.xml") }
}

kotlin {
    explicitApi()

    android { publishAllLibraryVariants() }

    iosArm64()
    iosX64()

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.mokokiCore)

                api(libs.jetbrains.kotlinx.kotlinxSerializationJson)
            }
        }
    }
}
