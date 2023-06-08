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
        multiplatform { //
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
