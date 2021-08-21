@file:Suppress("PropertyName", "VariableNaming")

// Catalog name: libs

// [versions]
val appCompat = "1.3.1"
val core = "1.6.0"
val coroutines = "1.5.1-native-mt"
val kotest = "4.6.1"
val serialization = "1.2.2"

// [libraries]
val androidx_appcompat_appcompat = "androidx.appcompat:appcompat:$appCompat"
val androidx_core_coreKtx = "androidx.core:core-ktx:$core"
val jetbrains_kotlin_kotlinTest = "org.jetbrains.kotlin:kotlin-test"
val jetbrains_kotlinx_kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
val jetbrains_kotlinx_kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization"
val kotest_kotestAssertionsCore = "io.kotest:kotest-assertions-core:$kotest"

// [bundles]
val testing = jetbrains_kotlin_kotlinTest + kotest_kotestAssertionsCore
