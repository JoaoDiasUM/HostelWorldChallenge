plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.hostelworldchallenge"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.hostelworldchallenge"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
   }

    buildTypes {
        debug {
            buildConfigField("String", "API_KEY", "\"https://gist.githubusercontent.com/\"")
            buildConfigField(
                "String",
                "GOOGLE_MAPS_KEY",
                "\"AIzaSyCmZ5LV40xya40M-A9o5b4VMxMmHzoPWyg\""
            )
            manifestPlaceholders["maps_key"] = "\"AIzaSyCmZ5LV40xya40M-A9o5b4VMxMmHzoPWyg\""
        }

        release {
            buildConfigField("String", "API_KEY", "\"https://gist.githubusercontent.com/\"")
            buildConfigField(
                "String",
                "GOOGLE_MAPS_KEY",
                "\"AIzaSyCmZ5LV40xya40M-A9o5b4VMxMmHzoPWyg\""
            )
            manifestPlaceholders["maps_key"] = "\"AIzaSyCmZ5LV40xya40M-A9o5b4VMxMmHzoPWyg\""
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Maps
    implementation(libs.play.services.maps)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.fragment)

    // Network
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation (libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.logging.interceptor)

    // Compose
    implementation (libs.maps.compose)
    implementation (libs.maps.compose.utils)
    implementation (libs.maps.compose.widgets)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation (libs.androidx.hilt.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Testing
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.android.compiler)
    testAnnotationProcessor(libs.hilt.android.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    androidTestAnnotationProcessor(libs.hilt.android.compiler)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.mockk.android)
    testImplementation (libs.mockk.agent)
    testImplementation(libs.turbine)
    testImplementation(libs.mockito.kotlin)

    // External
    implementation (libs.accompanist.swiperefresh)
    implementation(libs.jsoup)
    implementation(libs.core.splashscreen)
}