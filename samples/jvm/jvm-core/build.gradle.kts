plugins {
    `kotlin-jvm`
    application
    `javiersc-code-formatter`
}

application { mainClass.set("com.javiersc.mokoki.jvm.core.MainKt") }

dependencies { implementation(projects.mokokiCore) }
