package com.example.narasimhakonapalli_finalassignment.Response;

import com.example.narasimhakonapalli_finalassignment.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//This class is for single movie request
public class MovieResponse {
    //Finding Movie object
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public MovieModel getMovie()
    {
        return movie;
    }

    @Override
    public String toString()
    {
        return "MovieResponse{" + "movie=" + movie + '}';
    }
}
