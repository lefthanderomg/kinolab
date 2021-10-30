plugins {
    id("com.android.application")
    id("kotlin-android")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":core:core-ui"))
    implementation(project(":core:core-utils"))
    implementation(project(":core:api"))

    implementation(Libs.Core.kotlin)
    implementation(Libs.Android.appCompat)
    implementation(Libs.Android.material)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.androidJunit)
    androidTestImplementation(Libs.Test.espressoCore)
}