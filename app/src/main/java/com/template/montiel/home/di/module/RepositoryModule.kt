package com.template.montiel.home.di.module

import com.template.montiel.home.data.remote.datasource.CategoryDataSource
import com.template.montiel.home.data.repository.CategoryDataRepository
import com.template.montiel.home.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideCategoryRepository(
        categoryDataSource: CategoryDataSource
    ): CategoryRepository =
        CategoryDataRepository(categoryDataSource)

}
