package com.template.montiel.home.data.repository

import com.template.montiel.core.domain.model.Result
import com.template.montiel.core.domain.model.asResult
import com.template.montiel.home.data.remote.datasource.CategoryDataSource
import com.template.montiel.home.data.remote.model.CedearsCategoryResponse
import com.template.montiel.home.domain.repository.CategoryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class CategoryDataRepository @Inject constructor(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepository {

    override suspend fun getAllCategories(): Flow<Result<CedearsCategoryResponse>> =
        categoryDataSource.getAllCategories().asResult()

}
