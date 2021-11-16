plugins {
    id("org.jetbrains.kotlin.jvm")
    id("kotlinx-serialization")
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.okhttp)
    implementation(Libs.Network.kotlinSerialization)
    implementation(Libs.Network.kotlinSerializationConverter)
    implementation(Libs.Network.logging)
}