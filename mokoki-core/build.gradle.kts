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

    iosArm64()
    iosX64()

    jvm()

    sourceSets {
        val commonMain by getting

        named("androidMain") {
            dependencies { implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesCore) }
        }

        val iosArm64Main by getting
        val iosX64Main by getting

        named("jvmMain")

        val ios64Main by creating {
            dependsOn(commonMain)

            iosArm64Main.dependsOn(this)
            iosX64Main.dependsOn(this)
        }

        create("ios64Test") { dependsOn(ios64Main) }
    }
}
