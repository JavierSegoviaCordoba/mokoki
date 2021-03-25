plugins {
    `kotlin-jvm`
    application
    `javiersc-code-formatter`
}

application {
    mainClass.set("com.javiersc.mokoki.MainKt")
}

dependencies {
    implementation(projects.mokokiCore)
}
