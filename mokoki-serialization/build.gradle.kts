@file:Suppress("MagicNumber")

plugins {
    `javiersc-kotlin-multiplatform`
    `kotlinx-serialization`
    `javiersc-publish-kotlin-multiplatform`
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
