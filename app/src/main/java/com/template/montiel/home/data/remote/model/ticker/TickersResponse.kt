package com.template.montiel.home.data.remote.model.ticker

import com.google.gson.annotations.SerializedName

data class TickersResponse(
    @SerializedName("ticker")
    val ticker: String = "",
    @SerializedName("categories")
    val categories: List<String> = emptyList(),
)
