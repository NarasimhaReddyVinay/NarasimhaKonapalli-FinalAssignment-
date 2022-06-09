package com.example.narasimhakonapalli_finalassignment.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.narasimhakonapalli_finalassignment.Request.Service
import com.example.narasimhakonapalli_finalassignment.Response.MovieResponse
import com.example.narasimhakonapalli_finalassignment.Response.MovieSearchResponse
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentSearchBinding
import com.example.narasimhakonapalli_finalassignment.models.MovieModel
import com.example.narasimhakonapalli_finalassignment.utils.Credentials
import com.example.narasimhakonapalli_finalassignment.utils.MovieApi
import com.example.narasimhakonapalli_finalassignment.viewModels.MovieListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!


    //ViewModel
    private val viewModel: MovieListViewModel by lazy {
        object : ViewModelProvider.Factory{
            override fun <T: ViewModel> create(modelClass: Class<T>):T{
                return MovieListViewModel() as T
            }
        }.create(MovieListViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(layoutInflater)

        binding.searchButton.setOnClickListener {
            getRetrofitResponseToID()
        }

        return binding.root
    }

    //observing any data change
    private fun observeAnyChange(){
        viewModel.movies.observe(viewLifecycleOwner){ response ->

        }
    }

    private fun getRetrofitResponse() {
        val movieApi = Service.movieApi
        val responseCall = movieApi.searchMovie(Credentials.API_KEY, "Minions", "1")
        responseCall.enqueue(object : Callback<MovieSearchResponse> {
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>
            ) {
                if (response.isSuccessful) {
                    Log.v("Tag", "The response " + response.body().toString())

                    val movies: List<MovieModel> = ArrayList(response.body()!!.movies)
                    for (movie in movies) {
                        Log.v("Tag", "The release date " + movie.title)
                    }
                } else {
                    try {
                        Log.v("Tag", "Error" + response.errorBody()!!.string())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {}
        }
        )
    }

    private fun getRetrofitResponseToID() {
        val movieApi = Service.movieApi
        val responseCall = movieApi.getMovie(343611, Credentials.API_KEY)
        responseCall.enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                if (response.isSuccessful) {
                    Log.v("Tag", "The response " + response.body()?.title)

                } else {
                    try {
                        Log.v("Tag", "Error" + response.errorBody()!!.string())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }

                }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
        )


    }
}




