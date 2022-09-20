package com.template.montiel.home.data.remote.datasource

import com.template.montiel.home.data.remote.model.CategoryResponse
import com.template.montiel.home.data.remote.services.CategoryServices
import com.template.montiel.network.data.remote.ext.asResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryNetworkDataSource @Inject constructor(
    private val services: CategoryServices
) : CategoryDataSource {

    override suspend fun getAllCategories(): Flow<List<CategoryResponse>> =
        flow {
            emit(services.getAllCategories().asResponse {
                it.categories
            })
        }

}
