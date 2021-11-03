buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.Core.buildGradle)
        classpath(Libs.Core.kotlinPlugin)
        classpath(Libs.Dagger.daggerPlugin)
        classpath(Libs.Network.kotlinSerializationPlugin)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version("1.18.1").apply(false)
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}