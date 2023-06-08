hubdle {
    config {
        analysis()
        coverage()
        documentation {
            api()
        }
        explicitApi()
        publishing()
    }
    kotlin {
        multiplatform {
            features { //
                serialization()
            }

            common {
                main {
                    dependencies { //
                        implementation(projects.mokoki)
                    }
                }
            }

//            android()

//            apple {
//                enableAll()
//            }

            jvm()
//            jvmAndAndroid()
//
//            mingw {
//                enableAll()
//            }
        }
    }
}
