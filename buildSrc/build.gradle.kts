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

    Dependencies.Plugins.apply {
        implementation(dependencyUpdates)
        implementation(detekt)
        implementation(dokka)
        implementation(kotlin)
        implementation(kotlinSerialization)
        implementation(nexusStaging)
        implementation(nexusPublish)
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
