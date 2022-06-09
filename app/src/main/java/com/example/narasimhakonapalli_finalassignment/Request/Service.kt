package com.example.narasimhakonapalli_finalassignment.Request

import com.example.narasimhakonapalli_finalassignment.utils.Credentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.narasimhakonapalli_finalassignment.utils.MovieApi

object Service {
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(Credentials.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
    private val retrofit = retrofitBuilder.build()
    val movieApi = retrofit.create(
        MovieApi::class.java
    )
}