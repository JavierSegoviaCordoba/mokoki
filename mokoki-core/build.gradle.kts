@file:Suppress("MagicNumber")

plugins {
    `android-library`
    `javiersc-kotlin-multiplatform`
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

    jvm()

    sourceSets {
        commonMain

        named("androidMain") {
            dependencies { implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesCore) }
        }

        named("jvmMain")
    }
}
