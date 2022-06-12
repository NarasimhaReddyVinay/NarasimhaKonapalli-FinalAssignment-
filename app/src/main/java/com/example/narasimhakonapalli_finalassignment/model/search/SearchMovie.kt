package com.example.narasimhakonapalli_finalassignment.model.search

import com.google.gson.annotations.SerializedName

data class SearchMovie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val logo_path: String,
)