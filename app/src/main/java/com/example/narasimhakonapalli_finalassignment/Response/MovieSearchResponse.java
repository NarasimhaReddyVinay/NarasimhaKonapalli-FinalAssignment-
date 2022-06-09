package com.example.narasimhakonapalli_finalassignment.Response;

import com.example.narasimhakonapalli_finalassignment.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//This class is for getting multiple movies list - (popular movies)
public class MovieSearchResponse {
    @SerializedName("total_results")
    @Expose()
    private int total_count;

    @SerializedName("results")
    @Expose()
    private List<MovieModel> movies;


    public int getTotal_count()
    {
        return total_count;
    }

    public List<MovieModel> getMovies()
    {
        return movies;
    }

    @Override
    public String toString()
    {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies = " + movies +
                '}';
    }
}
