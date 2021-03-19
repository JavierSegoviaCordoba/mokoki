plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
}

application {
    mainClass.set("com.javiersc.mokoki.MainKt")
}

dependencies {
    implementation(projects.mokokiSerialization)
}
