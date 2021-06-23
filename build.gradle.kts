plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-formatter`
    `javiersc-dependency-updates`
    `javiersc-docs`
//    `kotlinx-binary-compatibility-validator`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

tasks {
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
