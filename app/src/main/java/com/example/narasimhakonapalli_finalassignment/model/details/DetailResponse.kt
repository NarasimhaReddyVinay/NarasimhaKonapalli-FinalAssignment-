package com.example.narasimhakonapalli_finalassignment.model.details

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("backdrop_path")
    val results: List<Any>,
)
