plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-dependency-updates`
    `javiersc-docs`
    //    `kotlinx-binary-compatibility-validator`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }

    dokkaHtmlMultiModule {
        removeChildTasks(
            listOf(
                project(":samples:android:android-core"),
                project(":samples:jvm:jvm-core"),
                project(":samples:jvm:jvm-serialization"),
            )
        )
    }
}
