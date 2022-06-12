package com.example.narasimhakonapalli_finalassignment.model.Trending

import com.google.gson.annotations.SerializedName

data class TrendingResponse(
    @SerializedName("results")
    val results: List<Any>
)
