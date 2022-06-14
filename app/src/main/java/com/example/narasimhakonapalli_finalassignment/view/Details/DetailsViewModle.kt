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

    private val _detailResponse = MutableLiveData<DetailResponse>()
    val detailResponse: LiveData<DetailResponse> = _detailResponse

    private val _castResponseList = MutableLiveData<ArrayList<Cast>>()
    val castResponseList: LiveData<ArrayList<Cast>> = _castResponseList

    private val _isfavorited = MutableLiveData<Boolean>()
    val isFavorited: LiveData<Boolean> = _isfavorited




    fun requestCast(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getCast()
            _castResponseList.postValue(response.id as ArrayList<Cast>?)
        }
    }



}


