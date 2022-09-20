package com.template.montiel.home.data.remote.services

import com.template.montiel.home.data.remote.model.CedearsCategoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CategoryServices {
    @Headers("Content-Type: application/json", "Connection: close")
    @GET("/cedears-categories.json")
    suspend fun getAllCategories(): Response<CedearsCategoryResponse>
}