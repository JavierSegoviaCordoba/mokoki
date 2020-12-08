plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    mavenCentral()
    google()
    gradlePluginPortal()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-serialization:${versions.kotlin}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${versions.detekt}")
    implementation("com.github.ben-manes:gradle-versions-plugin:${versions.dependencyUpdates}")
    implementation("io.codearte.gradle.nexus:gradle-nexus-staging-plugin:${versions.nexus}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${versions.dokka}")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
