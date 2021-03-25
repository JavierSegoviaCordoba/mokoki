plugins {
    `kotlin-serialization`
    `kotlinx-serialization`
    application
    `javiersc-code-formatter`
}

application {
    mainClass.set("com.javiersc.mokoki.MainKt")
}

dependencies {
    implementation(projects.mokokiSerialization)
}
