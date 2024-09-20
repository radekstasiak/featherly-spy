import java.net.URI

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.hilt.gradle.plugin) apply false
}

buildscript {
    repositories {
        mavenCentral()
    }

//    dependencies {
//        classpath(libs.plugins.hilt.android.plugin)
//    }
}
