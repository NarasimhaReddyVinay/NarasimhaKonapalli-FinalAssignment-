package com.example.narasimhakonapalli_finalassignment.model.upcoming

import com.google.gson.annotations.SerializedName

data class UpcomingResponse(
    @SerializedName("results")
    val results: List<PosterUpcoming>
)
