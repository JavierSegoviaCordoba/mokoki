plugins {
    `kotlin-jvm`
    `kotlinx-serialization`
    application
}

application { mainClass.set("com.javiersc.mokoki.jvm.serialization.MainKt") }

dependencies { implementation(projects.mokokiSerialization) }
