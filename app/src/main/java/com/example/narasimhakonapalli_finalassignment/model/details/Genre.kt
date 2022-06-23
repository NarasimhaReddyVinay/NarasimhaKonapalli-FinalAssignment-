package com.example.narasimhakonapalli_finalassignment.model.details


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)