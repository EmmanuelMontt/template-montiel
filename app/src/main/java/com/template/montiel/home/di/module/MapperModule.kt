package com.template.montiel.home.di.module

import com.template.montiel.home.ui.mapper.CategoryUIMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MapperModule {

    @Provides
    fun providesCategoryResponseMapper(): CategoryUIMapper =
        CategoryUIMapper()

}