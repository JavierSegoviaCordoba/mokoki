plugins {
    `javiersc-kotlin-multiplatform`
    `javiersc-publish-kotlin-multiplatform`
}

kotlin {
    explicitApi()

    android { publishAllLibraryVariants() }

    iosArm64()
    iosX64()

    jvm()

    sourceSets {
        val commonMain by getting
        val commonTest by getting

        named("androidMain") {
            dependencies { implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesCore) }
        }

        val iosArm64Main by getting
        val iosArm64Test by getting
        val iosX64Main by getting
        val iosX64Test by getting

        named("jvmMain")

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
