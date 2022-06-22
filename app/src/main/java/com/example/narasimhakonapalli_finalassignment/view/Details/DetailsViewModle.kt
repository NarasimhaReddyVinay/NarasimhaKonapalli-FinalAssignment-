package com.example.narasimhakonapalli_finalassignment.view.Details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.narasimhakonapalli_finalassignment.data.Repository
import com.example.narasimhakonapalli_finalassignment.model.cast.Cast
import com.example.narasimhakonapalli_finalassignment.model.details.DetailResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailsViewModle( val repository: Repository) : ViewModel() {

    private val _detailResponse = MutableLiveData<ArrayList<DetailResponse>>()
    val detailResponse: LiveData<ArrayList<DetailResponse>> = _detailResponse

    private val _castResponseList = MutableLiveData<ArrayList<Cast>>()
    val castResponseList: LiveData<ArrayList<Cast>> = _castResponseList

    private val _isfavorited = MutableLiveData<Boolean>()
    val isFavorited: LiveData<Boolean> = _isfavorited



    fun requestCast(cast: Int){
        CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getCast(cast)
            _castResponseList.postValue(response.id as ArrayList<Cast>?)
        }
    }

    fun requestDetailMovie(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getDetailMovie(id)
            _detailResponse.postValue(response.results as ArrayList<DetailResponse>)
        }
    }

}





