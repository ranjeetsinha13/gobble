plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}
android {
    compileSdk = 30
    defaultConfig {
        applicationId = "com.rs.gobble"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    val API_KEY: String by project
    buildTypes {
        getByName("release") {
            buildConfigField("String", "GOBBLE_API_KEY", API_KEY)
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            buildConfigField("String", "GOBBLE_API_KEY", API_KEY)
            isMinifyEnabled = false
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${LibVersions.kotlinVersion}")
    // Compose
    implementation("androidx.compose.ui:ui:${LibVersions.composeVersion}")
    implementation("androidx.compose.foundation:foundation:${LibVersions.composeVersion}")
    implementation("androidx.compose.runtime:runtime-livedata:${LibVersions.composeVersion}")
    implementation("androidx.compose.material:material:${LibVersions.composeVersion}")
    implementation("androidx.compose.material:material-icons-core:${LibVersions.composeVersion}")
    implementation("androidx.compose.material:material-icons-extended:${LibVersions.composeVersion}")


    implementation("androidx.appcompat:appcompat:${LibVersions.appcompatVersion}")
    implementation("androidx.core:core-ktx:${LibVersions.appcompatVersion}")
}