plugins {
    `kotlin-jvm`
    application
}

application { mainClass.set("com.javiersc.mokoki.jvm.core.MainKt") }

dependencies { implementation(projects.mokokiCore) }
