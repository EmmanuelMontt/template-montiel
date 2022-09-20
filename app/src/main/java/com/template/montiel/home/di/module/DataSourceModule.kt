package com.template.montiel.home.di.module

import com.template.montiel.home.data.remote.datasource.CategoryDataSource
import com.template.montiel.home.data.remote.datasource.CategoryNetworkDataSource
import com.template.montiel.home.data.remote.services.CategoryServices
import com.template.montiel.network.di.NetworkInstanceModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun providesCategoryServices(
        @NetworkInstanceModule.AmazonAPI retrofit: Retrofit
    ): CategoryServices =
        retrofit.create(CategoryServices::class.java)

    @Provides
    fun providesCategoryDataSource(
        services: CategoryServices
    ): CategoryDataSource =
        CategoryNetworkDataSource(
            services
        )

}
