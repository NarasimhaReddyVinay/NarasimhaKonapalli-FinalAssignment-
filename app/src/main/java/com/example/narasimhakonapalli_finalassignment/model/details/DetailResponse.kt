package com.example.narasimhakonapalli_finalassignment.model.details

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("homepage")
    val results: List<Any>
)
