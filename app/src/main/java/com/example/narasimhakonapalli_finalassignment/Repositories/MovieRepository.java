package com.example.narasimhakonapalli_finalassignment.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.narasimhakonapalli_finalassignment.models.MovieModel;
import java.util.List;

public class MovieRepository {
    //This class will act as repositories
    private static MovieRepository instance;
    //Live data
    private MutableLiveData<List<MovieModel>> mMovies;

    public static MovieRepository getInstance(){
        if(instance == null){
            instance = new MovieRepository();


        }
        return instance;
    }
    private MovieRepository(){

       mMovies= new MutableLiveData<>();

    }
    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }
}
