/**
 * Version 1.0.0
 */

object Versions {
    const val kotlin = "1.6.10"
    const val core_ktx = "1.8.0"
    const val glide = "4.13.0"
    const val retrofit = "2.9.0"
    const val okHttp = "4.10.0"
    const val hilt = "2.42"
    const val compose = "1.1.1"
    const val lottie = "5.2.0"
    const val coroutines = "1.6.2"
}

object Libs {

    val kotlin = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}",
        "androidx.core:core-ktx:${Versions.core_ktx}"
    )

    const val material = "com.google.android.material:material:1.6.1"
    const val appCompat = "androidx.appcompat:appcompat:1.4.2"

    val retrofit = arrayOf(
        "com.squareup.retrofit2:retrofit:${Versions.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}",
        "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    )

    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val kaptHilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val kaptHiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"

    val compose = arrayOf(
        "androidx.compose.ui:ui:${Versions.compose}",
        "androidx.compose.ui:ui-tooling:${Versions.compose}",
        "androidx.compose.foundation:foundation:${Versions.compose}",
        "androidx.compose.material:material:${Versions.compose}",
        "androidx.compose.material:material-icons-core:${Versions.compose}",
        "androidx.compose.material:material-icons-extended:${Versions.compose}",
        "androidx.compose.animation:animation:${Versions.compose}",
        "androidx.activity:activity-compose:1.4.0",
        "androidx.navigation:navigation-compose:2.4.2",
        "androidx.navigation:navigation-runtime-ktx:2.4.2",
        "androidx.constraintlayout:constraintlayout-compose:1.0.0",
        "androidx.hilt:hilt-navigation-compose:1.0.0",
        "com.google.accompanist:accompanist-flowlayout:0.23.1",
        "com.google.accompanist:accompanist-pager:0.23.1"
    )

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    val viewModel = arrayOf(
        "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1",
        "androidx.lifecycle:lifecycle-livedata-ktx:2.4.1",
        "androidx.activity:activity-ktx:1.4.0",
        "androidx.fragment:fragment-ktx:1.4.0"
    )

    /**
     * https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-livedata-core-ktx?repo=google
     */
    val livedataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.4.1"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val landscapist = "com.github.skydoves:landscapist-glide:1.5.2"

    val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    val lottieCompose = "com.airbnb.android:lottie-compose:${Versions.lottie}"

    val testing = arrayOf(
        "androidx.test:core:1.4.0",
        "androidx.test.ext:junit:1.1.3",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}",
        "app.cash.turbine:turbine:0.8.0",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2",
        "androidx.arch.core:core-testing:2.1.0",
        "io.mockk:mockk:1.12.4",
        "io.mockk:mockk-agent-jvm:1.12.4"
    )

    val jUnit = "junit:junit:4.13.2"

    val testingImplementation = arrayOf(
        "androidx.arch.core:core-testing:2.1.0",
        "androidx.test.ext:junit:1.1.3",
        "androidx.test.espresso:espresso-core:3.4.0",
        "io.mockk:mockk-agent-jvm:1.12.4"
    )

    val playCore = "com.google.android.play:core:1.10.3"

}