pluginManagement {
    val hubdleVersion: String =
        file("$rootDir/gradle/libs.versions.toml")
            .readLines()
            .first { it.contains("hubdle") }
            .split("\"")[1]

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
//        mavenLocal()
    }

    plugins { //
        id("com.javiersc.hubdle") version hubdleVersion
    }
}

plugins { //
    id("com.javiersc.hubdle")
}

hubdleSettings {
    autoInclude { //
        excludes(
            ":mokoki-old",
            ":mokoki-serialization-old",
            ":samples:android:android-core",
            ":samples:jvm:jvm-core",
            ":samples:jvm:jvm-serialization",
        )
    }
}
