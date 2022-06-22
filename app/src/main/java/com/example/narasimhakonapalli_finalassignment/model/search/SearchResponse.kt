package com.example.narasimhakonapalli_finalassignment.model.search

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("results")
    val results: List<SearchMovie>
        )