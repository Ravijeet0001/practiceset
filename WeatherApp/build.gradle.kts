// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.0")  // Ensure this is the correct version for your Android Studio
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")  // Ensure Kotlin plugin is included
    }
}