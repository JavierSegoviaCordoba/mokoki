![Kotlin version](https://img.shields.io/badge/kotlin-1.7.10-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.mokoki/mokoki?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/mokoki/mokoki/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.mokoki/mokoki?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/mokoki/mokoki/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/mokoki/build-kotlin?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/mokoki/tree/main)
[![Coverage](https://img.shields.io/sonar/coverage/com.javiersc.mokoki:mokoki?label=Coverage&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.mokoki:mokoki)
[![Quality](https://img.shields.io/sonar/quality_gate/com.javiersc.mokoki:mokoki?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.mokoki:mokoki)
[![Tech debt](https://img.shields.io/sonar/tech_debt/com.javiersc.mokoki:mokoki?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.mokoki:mokoki)

# [Mokoki](https://mokoki.javiersc.com)

- Normal

![log-normal](.docs/docs/assets/log-verbose.png)

- Json or Kotlin Serialization

![log-normal-json](.docs/docs/assets/log-verbose-json.png)

## Download

This library is Kotlin Multiplatform but at this moment jvm is the only artifact generated. It is
available at Maven Central.

- Logger:

```kotlin
implementation("com.javiersc.mokoki:mokoki:$version")
```

- Serialization

```kotlin
implementation("com.javiersc.mokoki:mokoki-serialization:$version")
```
