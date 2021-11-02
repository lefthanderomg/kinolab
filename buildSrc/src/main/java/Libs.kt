object Libs {

    object Core {
        private const val kotlinVersion = "1.5.21"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val buildGradle = "com.android.tools.build:gradle:7.0.3"
    }

    object Android {
        private const val lifecycleVersion = "2.4.0"

        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val androidJunit = "androidx.test.ext:junit:1.1.3"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object Compose {
        const val composeVersion = "1.0.1"

        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val material = "androidx.compose.material:material:$composeVersion"
        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val junit = "androidx.compose.ui:ui-test-junit4:1.0.1"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-beta01"
        const val inset = "com.google.accompanist:accompanist-insets:0.19.0"
        const val materialIcon = "androidx.compose.material:material-icons-core:$composeVersion"
    }

    object Dagger {
        private const val daggerVersion = "2.39.1"

        const val daggerPlugin = "com.google.dagger:hilt-android-gradle-plugin:$daggerVersion"
        const val daggerHilt = "com.google.dagger:hilt-android:$daggerVersion"
        const val daggerCompiler = "com.google.dagger:hilt-android-compiler:$daggerVersion"

        const val daggerHiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
    }
}