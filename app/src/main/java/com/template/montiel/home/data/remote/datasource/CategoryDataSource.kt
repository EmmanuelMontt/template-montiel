package com.template.montiel.home.data.remote.datasource

import com.template.montiel.home.data.remote.model.CategoryResponse
import kotlinx.coroutines.flow.Flow

interface CategoryDataSource {
    suspend fun getAllCategories(): Flow<List<CategoryResponse>>
}