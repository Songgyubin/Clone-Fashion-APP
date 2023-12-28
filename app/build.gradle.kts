import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
        multiDexEnabled = true

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
        mutableSetOf(
            "META-INF/LICENSE.txt", // META-INF 디렉터리에 있는 LICENSE.txt 파일을 제외합니다.
            "META-INF/LICENSE", // META-INF 디렉터리에 있는 LICENSE 파일을 제외합니다.
            "META-INF/NOTICE.txt", // META-INF 디렉터리에 있는 NOTICE.txt 파일을 제외합니다.
            "META-INF/NOTICE", // META-INF 디렉터리에 있는 NOTICE 파일을 제외합니다.
            "META-INF/ASL2.0", // META-INF 디렉터리에 있는 ASL2.0 파일을 제외합니다.
            "META-INF/DEPENDENCIES", // META-INF 디렉터리에 있는 DEPENDENCIES 파일을 제외합니다.
            "META-INF/maven/com.google.guava/guava/pom.properties", // META-INF/maven/com.google.guava/guava/ 디렉터리에 있는 pom.properties 파일을 제외합니다.
            "META-INF/maven/com.google.guava/guava/pom.xml", // META-INF/maven/com.google.guava/guava/ 디렉터리에 있는 pom.xml 파일을 제외합니다.
            "META-INF/rxjava.properties", // META-INF 디렉터리에 있는 rxjava.properties 파일을 제외합니다.
            ".readme", // .readme 파일을 제외합니다.
            "/META-INF/LGPL2.1"
        )
//        excludes +=
//        excludes += "/META-INF/AL2.0"
//        excludes += "META-INF/gradle/incremental.annotation.processors"
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
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.okhttp3)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofit2.jackson)
    implementation(libs.okhttp3.logging.interceptor)

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.android.test.androidx.ext.junit)
    androidTestImplementation(libs.android.test.androidx.espresso.core)

    val testComposeBom = platform(libs.android.test.androidx.compose.bom)
    androidTestImplementation(testComposeBom)
    androidTestImplementation(libs.android.test.androidx.espresso.core)

    debugImplementation(libs.debug.androidx.compose.ui.tooling)
    debugImplementation(libs.debug.androidx.compose.ui.test.manifest)
}
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? = add("kapt", dependencyNotation)