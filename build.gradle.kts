buildscript {
    dependencies {
        classpath(libs.android.toolsBuild.gradle)
        classpath(libs.jetbrains.kotlin.kotlinGradlePlugin)
    }
}

plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        analysis()
        binaryCompatibilityValidator()
        coverage()
        documentation {
            changelog()
            readme {
                badges()
            }
            site {
                excludes(
                    projects.mokokiTest,
                    projects.samples.android.androidCore,
                    projects.samples.jvm.jvmCore,
                    projects.samples.jvm.jvmSerialization,
                )
            }
        }
        nexus()
    }
}
