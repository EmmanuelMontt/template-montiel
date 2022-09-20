package com.template.montiel.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class CedearsCategoryResponse(
    @SerializedName("cedearsCategories")
    val categories: List<CategoryResponse> = emptyList()
)