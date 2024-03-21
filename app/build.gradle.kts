plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "me.vehbi.presview"
    compileSdk = 34

    defaultConfig {
        applicationId = "me.vehbi.presview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.webkit:webkit:1.8.0")

}