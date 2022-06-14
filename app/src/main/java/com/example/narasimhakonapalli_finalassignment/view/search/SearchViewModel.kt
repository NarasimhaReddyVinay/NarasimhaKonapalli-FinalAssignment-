package com.example.narasimhakonapalli_finalassignment.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.narasimhakonapalli_finalassignment.data.Repository
import com.example.narasimhakonapalli_finalassignment.model.search.SearchMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(val repository: Repository) : ViewModel() {

    private val _searchMovieList = MutableLiveData<ArrayList<SearchMovie>>()
    val searchMovieList: LiveData<ArrayList<SearchMovie>> = _searchMovieList



    fun requestMovieQuery(query:String?) {
        CoroutineScope(Dispatchers.Main).launch{
            val response = repository.getMovieQuery(query)
            _searchMovieList.postValue(response.results as ArrayList<SearchMovie>?)
        }
    }
}





