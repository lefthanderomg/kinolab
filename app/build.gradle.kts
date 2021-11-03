import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import java.util.Properties


plugins {
    id("com.android.application")
    id("kotlin-android")
    id("io.gitlab.arturbosch.detekt")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

hilt {
    enableExperimentalClasspathAggregation = true
}

val localProperties = Properties()
val localPropertiesFile = File(rootProject.rootDir, "local.properties")
if (localPropertiesFile.exists() && localPropertiesFile.isFile) {
    localPropertiesFile.inputStream().use( localProperties::load)
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

        val themoviedbApiKey = checkNotNull(localProperties.getProperty("THEMOVIEDB_API_KEY"))
        buildConfigField("String", "THEMOVIEDB_API_KEY", themoviedbApiKey)
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

    packagingOptions {
        resources {
            excludes += "META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.composeVersion
    }
}

dependencies {
    implementation(project(":core:core-ui"))
    implementation(project(":core:core-utils"))
    implementation(project(":core:api"))
    implementation(project(":feature:home"))

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