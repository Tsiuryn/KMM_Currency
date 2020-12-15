plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "by.st.generatorforms.athis"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")


    implementation("androidx.core:core-ktx:1.3.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7-1.4-M3")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "by.st.generatorforms.athis.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}