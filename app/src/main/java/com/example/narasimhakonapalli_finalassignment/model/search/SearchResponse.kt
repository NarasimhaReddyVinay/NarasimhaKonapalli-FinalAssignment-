package com.example.narasimhakonapalli_finalassignment.model.search


import com.example.narasimhakonapalli_finalassignment.model.search.SearchMovie
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("results")
    val results: List<SearchMovie>
        )