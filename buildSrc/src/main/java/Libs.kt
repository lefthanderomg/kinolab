object Libs {

    object Core {
        val kotlinVersion = "1.5.31"
        val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val buildGradle = "com.android.tools.build:gradle:7.0.3"
    }

    object Android {
        val coreKtx = "androidx.core:core-ktx:1.7.0"
        val appCompat = "androidx.appcompat:appcompat:1.3.1"
        val material = "com.google.android.material:material:1.4.0"
    }

    object Test {
        val junit = "junit:junit:4.+"
        val androidJunit = "androidx.test.ext:junit:1.1.3"
        val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    }
}