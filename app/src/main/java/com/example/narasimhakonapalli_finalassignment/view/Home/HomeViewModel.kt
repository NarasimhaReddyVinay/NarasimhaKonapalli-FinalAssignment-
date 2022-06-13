package com.example.narasimhakonapalli_finalassignment.view.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.narasimhakonapalli_finalassignment.data.Repository
import com.example.narasimhakonapalli_finalassignment.model.Trending.PosterTrending
import com.example.narasimhakonapalli_finalassignment.model.Trending.TrendingResponse
import com.example.narasimhakonapalli_finalassignment.model.search.SearchMovie
import com.example.narasimhakonapalli_finalassignment.model.upcoming.PosterUpcoming
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(val repository: Repository): ViewModel() {


    private val _trendingResponseList = MutableLiveData<ArrayList<PosterTrending>>()
    val trendingResponseList: LiveData<ArrayList<PosterTrending>> = _trendingResponseList

    private val _upcomingResponseList = MutableLiveData<ArrayList<PosterUpcoming>>()
    val upcomingResponseList: LiveData<ArrayList<PosterUpcoming>> = _upcomingResponseList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage


    fun requestUpcoming(){
        CoroutineScope(Dispatchers.Main).launch{
            val response = repository.getUpcoming()
            _upcomingResponseList.postValue(response.results as ArrayList<PosterUpcoming>?)
        }
    }

    fun requestTrending() {
        CoroutineScope(Dispatchers.Main).launch{
            val response = repository.getTrending()
            _trendingResponseList.postValue(response.results as ArrayList<PosterTrending>?)
        }
    }

}