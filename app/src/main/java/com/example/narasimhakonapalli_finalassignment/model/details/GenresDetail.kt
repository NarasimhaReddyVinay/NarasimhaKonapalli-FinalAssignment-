package com.example.narasimhakonapalli_finalassignment.model.details

import com.google.gson.annotations.SerializedName

class GenresDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nameGenre: String
)