plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // 👇 NECESARIO CON KOTLIN 2.0
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.nutriritmo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nutriritmo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }



    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Material Components para el tema XML
    implementation("com.google.android.material:material:1.12.0")

    // *** COMPOSE ***
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-graphics")

    // *** ACTIVITY COMPOSE ***
    implementation("androidx.activity:activity-compose:1.8.2")

    // *** NAVIGATION COMPOSE ***
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // TEST
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // DEBUG
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
