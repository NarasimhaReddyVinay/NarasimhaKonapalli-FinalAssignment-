package com.example.narasimhakonapalli_finalassignment.viewModels;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.narasimhakonapalli_finalassignment.Repositories.MovieRepository;
import com.example.narasimhakonapalli_finalassignment.models.MovieModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    //this class is used for ViewModel

    //instance of the repository
    private MovieRepository movieRepository;


    //Constructor

    public MovieListViewModel() {
        movieRepository = MovieRepository.getInstance();

    }

    public LiveData<List<MovieModel>> getMovies(){
        return movieRepository.getMovies();
    }


}

