@file:Suppress("MagicNumber")

plugins {
    `kotlin-multiplatform`
    `android-library`
    `kotlinx-serialization`
    `javiersc-kotlin-config`
    `javiersc-publish`
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
