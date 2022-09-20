package com.template.montiel.home.domain.repository

import com.template.montiel.core.domain.model.Result
import com.template.montiel.home.data.remote.model.CategoryResponse
import com.template.montiel.home.data.remote.model.CedearsCategoryResponse
import kotlinx.coroutines.flow.Flow

interface CategoryRepository  {
    suspend fun getAllCategories(): Flow<Result<CedearsCategoryResponse>>
}