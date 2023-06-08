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
            common {
                test {
                    dependencies {
                        //implementation(projects.mokokiTest)
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
