package com.template.montiel.network.di

import android.content.Context
import com.template.montiel.network.data.remote.datasource.Network
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkInstanceModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AmazonAPI

    @Provides
    fun provideNetwork(@ApplicationContext context: Context): Network =
        Network(context)

    @AmazonAPI
    @Provides
    @Singleton
    fun provideAmazonAPIAPI(
        network: Network
    ): Retrofit =
        network.createRetrofit("https://cedears-categories.s3.amazonaws.com", "BODY")

}
