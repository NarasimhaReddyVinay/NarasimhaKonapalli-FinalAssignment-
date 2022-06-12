package com.example.narasimhakonapalli_finalassignment.view.search

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemSearch
import com.example.narasimhakonapalli_finalassignment.adapter.SearchAdapter
import com.example.narasimhakonapalli_finalassignment.data.RepositoryImpl
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentSearchBinding
import com.example.narasimhakonapalli_finalassignment.model.search.SearchMovie


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!


    private val viewModel: SearchViewModel by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>):T{
                return SearchViewModel(RepositoryImpl()) as T
            }
        }.create(SearchViewModel::class.java)
    }

    private val adapterSearch:SearchAdapter by lazy {
        SearchAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentSearchBinding.inflate(layoutInflater)


        searchMovie()
        setListSearch()
        observeSearch()

        return binding.root

    }

    private fun searchMovie() {
        binding.searchMovie.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean{
                binding.searchMovie.clearFocus()
                viewModel.requestMovieQuery(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun observeSearch(){
        viewModel.searchMovieList.observe(viewLifecycleOwner,{
            adapterSearch.setDataSearch(it)
        })
    }

    private fun setListSearch(){
        binding.apply {
           rvMovieSearch.layoutManager=LinearLayoutManager(requireContext())
           rvMovieSearch.setHasFixedSize(true)
           rvMovieSearch.adapter = adapterSearch
        }
        adapterSearch.onClickItemSearch = object : OnClickItemSearch {
            override fun onClick(searchMovie: SearchMovie){

            }
        }
    }


}











