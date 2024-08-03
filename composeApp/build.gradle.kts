//import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)

    kotlin("plugin.serialization") version "2.0.0"
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            // Koin DI
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            // Kotlin Coroutines
            // implementation(libs.kotlinx.coroutines.android)
            // Network
            implementation(libs.ktor.client.okhttp)
            // implementation(libs.ktor.client.json) // todo need?
            // implementation(libs.ktor.serialization) // todo need?
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)
            // Logging
            implementation(libs.napier)
        }
        iosMain.dependencies {
            // Network
            implementation(libs.ktor.client.darwin)
            // Logging
            implementation(libs.napier)
        }
        commonMain.dependencies {
            // Compose UI
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            // Koin DI
            api(libs.koin.core)
            implementation(libs.koin.compose)
            // Kotlin Coroutines
            implementation(libs.kotlinx.coroutines.core)
            // ViewModel
            implementation(libs.lifecycle.viewmodel)
            // Navigation
            implementation(libs.navigation.compose)
            // Network
            implementation(libs.ktor.client.core)
            // implementation(libs.ktor.client.json) // todo need?
            implementation(libs.ktor.client.logging)
            // Logging
            implementation(libs.napier)
            // Other
            implementation(libs.serialization.json)
        }
    }
}

android {
    namespace = "org.example.zoodbia"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.zoodbia"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

