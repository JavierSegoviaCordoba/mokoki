plugins {
    `kotlin-jvm`
    `kotlinx-serialization`
    application
    `javiersc-code-formatter`
}

application { mainClass.set("com.javiersc.mokoki.jvm.serialization.MainKt") }

dependencies { implementation(projects.mokokiSerialization) }
