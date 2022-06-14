package com.example.narasimhakonapalli_finalassignment.data

import com.example.narasimhakonapalli_finalassignment.Api.ApiService
import com.example.narasimhakonapalli_finalassignment.model.Trending.TrendingResponse
import com.example.narasimhakonapalli_finalassignment.model.search.SearchResponse
import com.example.narasimhakonapalli_finalassignment.model.upcoming.UpcomingResponse
import com.example.narasimhakonapalli_finalassignment.model.cast.CastResponse
import com.example.narasimhakonapalli_finalassignment.model.details.DetailResponse


interface Repository{
    suspend fun getMovieQuery(query: String?): SearchResponse

    suspend fun getTrending(): TrendingResponse

    suspend fun getUpcoming(): UpcomingResponse

    suspend fun getCast(): CastResponse

    suspend fun getDetailMovie(id: Int?): DetailResponse
}

class RepositoryImpl(private val Service: ApiService = ApiService.getApiService()): Repository
{
    override suspend fun getMovieQuery(query: String?): SearchResponse {
        val response=Service.getMovieQuery(query = query.toString())
        return if(response.isSuccessful){
            response.body()!!
        }else{
            SearchResponse(emptyList())
        }
    }

    override suspend fun getDetailMovie(id: Int?): DetailResponse {
        val response=Service.getDetailMovie(id = id!!.toInt())
        return if(response.isSuccessful){
            response.body()!!
        }else{
            DetailResponse((emptyList()))
        }
    }


    override suspend fun getTrending(): TrendingResponse {
        val response=Service.getTrending()
        return if (response.isSuccessful){
            response.body()!!
        }else{
            TrendingResponse(emptyList())
        }
        }

    override suspend fun getUpcoming(): UpcomingResponse {
        val response=Service.getUpcoming()
        return if (response.isSuccessful){
            response.body()!!
        }else{
            UpcomingResponse(emptyList())
        }
    }

    override suspend fun getCast(): CastResponse {
        val response=Service.getCast()
        return if (response.isSuccessful){
            response.body()!!
        }else{
            CastResponse(emptyList())
        }
    }



}