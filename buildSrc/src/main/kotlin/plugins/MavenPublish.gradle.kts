plugins {
    id("maven-publish")
    `java-library`
    signing
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}

val isLoggerReleaseEnv: Boolean? = System.getenv("isLoggerReleaseEnv")?.toBoolean()
val isLoggerRelease: String by project

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("Logger")
            description.set("Logger Multiplatform")
            url.set("http://github.com/JavierSegoviaCordoba/logger")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("JavierSegoviaCordoba")
                    name.set("Javier Segovia Cordoba")
                    email.set("javiersegoviacordoba@gmail.com")
                }
            }
            scm {
                url.set("https://github.com/JavierSegoviaCordoba/logger")
                connection.set("scm:git:https://github.com/JavierSegoviaCordoba/logger.git")
                developerConnection.set("scm:git:git@github.com:JavierSegoviaCordoba/logger.git")
            }
        }
        repositories {
            val releasesRepo = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
            val snapshotsRepo = "https://oss.sonatype.org/content/repositories/snapshots"

            val isRelease = isLoggerReleaseEnv ?: isLoggerRelease.toBoolean()

            maven(if (isRelease) releasesRepo else snapshotsRepo) {
                credentials {
                    username = System.getenv("ossUser")
                    password = System.getenv("ossToken")
                }
            }
        }
    }
}
