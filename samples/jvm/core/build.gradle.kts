plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("com.javiersc.mokoki.MainKt")
}

dependencies {
    implementation(projects.mokoki)
}
