package com.example.narasimhakonapalli_finalassignment.data

import com.example.narasimhakonapalli_finalassignment.Api.ApiService
import com.example.narasimhakonapalli_finalassignment.model.Trending.TrendingResponse
import com.example.narasimhakonapalli_finalassignment.model.search.SearchResponse
import com.example.narasimhakonapalli_finalassignment.model.upcoming.UpcomingResponse


interface Repository{
    suspend fun getMovieQuery(query: String?): SearchResponse

    suspend fun getTrending(): TrendingResponse

    suspend fun getUpcoming(): UpcomingResponse
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

}