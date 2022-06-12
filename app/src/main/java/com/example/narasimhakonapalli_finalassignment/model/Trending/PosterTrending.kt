package com.example.narasimhakonapalli_finalassignment.model.Trending

import com.google.gson.annotations.SerializedName

data class PosterTrending(
    @SerializedName("id")
    val id : Int,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("original_title")
    val title: String


)
