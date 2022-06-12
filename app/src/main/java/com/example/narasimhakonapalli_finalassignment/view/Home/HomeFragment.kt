package com.example.narasimhakonapalli_finalassignment.view.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.narasimhakonapalli_finalassignment.adapter.TrendingAdapter
import com.example.narasimhakonapalli_finalassignment.adapter.UpcomingAdapter
import com.example.narasimhakonapalli_finalassignment.data.RepositoryImpl
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentHomeBinding
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemTrending
import com.example.narasimhakonapalli_finalassignment.model.Trending.PosterTrending



class HomeFragment : Fragment() {


    private val adapterTrending: TrendingAdapter by lazy {
        TrendingAdapter()
    }

    private val adapterUpcoming: UpcomingAdapter by lazy {
        UpcomingAdapter()
    }




    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: HomeViewModel by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(RepositoryImpl()) as T
            }
        }.create(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        setListTrending()
        observeTrending()

        observeUpcoming()
        setListUpcoming()


        return binding.root
    }

    private fun observeUpcoming() {
        viewModel.upcomingResponseList.observe(viewLifecycleOwner,{
            adapterUpcoming.setDataUpcoming(it)
        })
    }

    private fun setListUpcoming() {

    }

    private fun observeTrending() {
        viewModel.trendingResponseList.observe(viewLifecycleOwner,{
            adapterTrending.setDataTrending(it)
        })
    }

    private fun setListTrending() {
        binding.rvTrending.setHasFixedSize(true)
        binding.rvTrending.adapter = adapterTrending
        adapterTrending.onClickListener = object : OnClickItemTrending{
            override fun onClick(posterTrending: PosterTrending) {
                TODO("Not yet implemented")
            }
        }
    }


}