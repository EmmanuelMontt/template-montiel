package com.template.montiel.home.data.remote.model

import com.google.gson.annotations.SerializedName
import com.template.montiel.home.data.remote.model.ticker.TickersResponse

data class CedearsCategoryResponse(
    @SerializedName("cedearsCategories")
    val categories: List<CategoryResponse> = emptyList(),
    @SerializedName("tickersCategories")
    val tickers: List<TickersResponse> = emptyList()
)
