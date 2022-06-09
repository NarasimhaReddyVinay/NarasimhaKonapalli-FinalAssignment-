package com.example.narasimhakonapalli_finalassignment.utils;

import static com.example.narasimhakonapalli_finalassignment.utils.Credentials.API_KEY;

import com.example.narasimhakonapalli_finalassignment.Response.MovieSearchResponse;
import com.example.narasimhakonapalli_finalassignment.models.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    //Search for movies
    //https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    @GET("3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String Key,
            @Query("query") String query,
            @Query("page") String page
    );

    //Making search with ID
    //https://api.themoviedb.org/3/movie/550?api_key=09b66a12555e10d6a8eaec691fb01c94

    @GET("3/movie/{movie_id}?")
    Call<MovieModel> getMovie(
            @Path("movie_id" )int movie_id,
            @Query("api_key") String api_key
    );

}
