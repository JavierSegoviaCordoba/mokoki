plugins {
    `kotlin-multiplatform`
    `android-library`
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
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(libs.jetbrains.kotlin.kotlinTest)
                implementation(libs.kotest.kotestAssertionsCore)
            }
        }

        val iosArm64Main by getting
        val iosArm64Test by getting
        val iosX64Main by getting
        val iosX64Test by getting

        create("ios64Main") {
            dependsOn(commonMain)

            iosArm64Main.dependsOn(this)
            iosX64Main.dependsOn(this)
        }

        create("ios64Test") {
            dependsOn(commonTest)

            iosArm64Test.dependsOn(this)
            iosX64Test.dependsOn(this)
        }
    }
}
