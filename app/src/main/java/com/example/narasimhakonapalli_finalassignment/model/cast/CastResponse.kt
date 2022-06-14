package com.example.narasimhakonapalli_finalassignment.model.cast

import com.google.gson.annotations.SerializedName

data class CastResponse(
    @SerializedName("id")
    val id: List<Cast>
)
