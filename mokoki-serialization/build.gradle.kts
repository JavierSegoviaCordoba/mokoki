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

    jvm()

    android { publishAllLibraryVariants() }

    sourceSets {
        commonMain {
            dependencies {
                api(projects.mokoki)

                api(libs.jetbrains.kotlinx.kotlinxSerializationJson)
            }
        }
    }
}
