plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-coverage`
    `javiersc-code-formatter`
    `javiersc-docs`
    `kotlinx-binary-compatibility-validator`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

removeProjectFromDoc(
    ":samples:android:android-core",
    ":samples:jvm:jvm-core",
    ":samples:jvm:jvm-serialization",
)

fun removeProjectFromDoc(vararg paths: String) {
    val projects = mutableListOf<Project>()

    for (path in paths) {
        if (findProject(path) != null) projects.add(project(path))
    }

    tasks { dokkaHtmlMultiModule { removeChildTasks(projects) } }
}
