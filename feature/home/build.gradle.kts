import java.util.Properties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("io.gitlab.arturbosch.detekt")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

val localProperties = Properties()
val localPropertiesFile = File(rootProject.rootDir, "local.properties")
if (localPropertiesFile.exists() && localPropertiesFile.isFile) {
    localPropertiesFile.inputStream().use( localProperties::load)
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        vectorDrawables {
            useSupportLibrary = true
        }

        val themoviedbApiKey = checkNotNull(localProperties.getProperty("THEMOVIEDB_API_KEY"))
        buildConfigField("String", "THEMOVIEDB_API_KEY", "\"$themoviedbApiKey\"")
    }

    buildTypes {
        release {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.composeVersion
    }
}

dependencies {
    implementation(Libs.Core.kotlin)
    implementation(Libs.Android.appCompat)
    implementation(Libs.Android.material)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.androidJunit)
    androidTestImplementation(Libs.Test.espressoCore)

    implementation(Libs.Dagger.daggerHilt)
    implementation(Libs.Dagger.daggerHiltNavigationCompose)
    kapt(Libs.Dagger.daggerCompiler)

    implementation(Libs.Compose.activity)
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.uiTooling)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.navigation)
    implementation(Libs.Compose.inset)
    implementation(Libs.Compose.materialIcon)
}