import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.rs.gobble"
        minSdkVersion(21)
        targetSdkVersion(29)
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
    implementation("androidx.compose:compose-runtime:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-core:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-layout:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-framework:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-material:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-foundation:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-text:${LibVersions.composeVersion}")
    implementation("androidx.ui:ui-tooling:${LibVersions.composeVersion}")
    implementation("androidx.appcompat:appcompat:${LibVersions.appcompatVersion}")
    implementation("androidx.core:core-ktx:${LibVersions.appcompatVersion}")

    // Dagger
    implementation("com.google.dagger:dagger:${LibVersions.daggerVersion}")
    implementation("com.google.dagger:dagger-android-support:${LibVersions.daggerVersion}")
    kapt("com.google.dagger:dagger-compiler:${LibVersions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${LibVersions.daggerVersion}")


    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${LibVersions.retrofitVersion}")
    implementation("com.google.code.gson:gson:${LibVersions.gsonVersion}")
    implementation("com.squareup.retrofit2:converter-gson:${LibVersions.retrofitVersion}")

    // Okhttp
    implementation ("com.squareup.okhttp3:logging-interceptor:${LibVersions.okhttpVersion}")
    implementation ("com.squareup.okhttp3:okhttp:${LibVersions.okhttpVersion}")

    // LiveData and ViewModel
    implementation("android.arch.lifecycle:extensions:${LibVersions.lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.viewModelKtxVersion}")

    // Room
    implementation("androidx.room:room-runtime:${LibVersions.roomVersion}")
    kapt("androidx.room:room-compiler:${LibVersions.roomVersion}")

    // testing
    testImplementation("junit:junit:${LibVersions.junitVersion}")

    // Dagger

    //Multidex
    implementation("androidx.multidex:multidex:${LibVersions.multidexVersion}")
}