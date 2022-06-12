package com.example.narasimhakonapalli_finalassignment.Api

import com.example.narasimhakonapalli_finalassignment.model.Trending.TrendingResponse
import com.example.narasimhakonapalli_finalassignment.model.search.SearchResponse
import com.example.narasimhakonapalli_finalassignment.model.upcoming.UpcomingResponse
import com.example.narasimhakonapalli_finalassignment.util.Constant
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("search/movie")
    suspend fun getMovieQuery(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE,
        @Query("page") page: String = Constant.PAGE,
        @Query("include_adult") adult: String = Constant.INCLUDE_ADULT
    ): Response<SearchResponse>

    @GET("trending/all/day")
    suspend fun getTrending(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE
    ): Response<TrendingResponse>

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE
    ): Response<UpcomingResponse>

    companion object {
        private var instance: ApiService? = null
        fun getApiService(): ApiService{
            if (instance == null){
                instance = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return instance!!
        }
    }
}