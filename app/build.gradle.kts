plugins {
    id("dagger.hilt.android.plugin")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.gyub.kkangtongdummy"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.gyub.kkangtongdummy"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging.resources {
        // Multiple dependency bring these files in. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        excludes += "/META-INF/AL2.0"
        excludes += "/META-INF/LGPL2.1"
        excludes += "META-INF/gradle/incremental.annotation.processors"
    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preivew)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.okhttp3)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofit2.jackson)
    implementation(libs.okhttp3.logging.interceptor)

    implementation(libs.dagger.hilt)
    implementation(libs.dagger.hilt.compiler)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.android.test.androidx.ext.junit)
    androidTestImplementation(libs.android.test.androidx.espresso.core)

    val testComposeBom = platform(libs.android.test.androidx.compose.bom)
    androidTestImplementation(testComposeBom)
    androidTestImplementation(libs.android.test.androidx.espresso.core)

    debugImplementation(libs.debug.androidx.compose.ui.tooling)
    debugImplementation(libs.debug.androidx.compose.ui.test.manifest)
}