package com.template.montiel.network.data.remote.datasource

import android.content.Context
import com.google.gson.Gson
import com.template.montiel.network.data.remote.interceptor.NetworkConnectionInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network @Inject constructor(
    private val context: Context
) {

    private fun getRetrofitLevel(level: String?) =
        when (level) {
            "BODY" -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }

    private fun getLoggingInterceptor(level: String?): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            this.level = getRetrofitLevel(level)
        }

    private fun getOkHttpClientBuilder(level: String?): OkHttpClient.Builder =
        OkHttpClient.Builder().apply {
            addInterceptor(getLoggingInterceptor(level))
            addInterceptor(NetworkConnectionInterceptor(context))
            connectTimeout(SECONDS_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(SECONDS_TIMEOUT, TimeUnit.SECONDS)
        }

    private fun getGson() = Gson()

    fun createRetrofit(url: String, level: String? = null): Retrofit =
        Retrofit.Builder()
            .baseUrl(url)
            .client(getOkHttpClientBuilder(level).build())
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .build()

    companion object {
        const val SECONDS_TIMEOUT = 60L
    }

}
