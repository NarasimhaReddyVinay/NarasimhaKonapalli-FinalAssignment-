package com.example.narasimhakonapalli_finalassignment.view.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.narasimhakonapalli_finalassignment.view.Details.DetailsActivity
import com.example.narasimhakonapalli_finalassignment.adapter.TrendingAdapter
import com.example.narasimhakonapalli_finalassignment.adapter.UpcomingAdapter
import com.example.narasimhakonapalli_finalassignment.data.RepositoryImpl
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentHomeBinding
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemTrending
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemUpcoming
import com.example.narasimhakonapalli_finalassignment.model.Trending.PosterTrending
import com.example.narasimhakonapalli_finalassignment.model.upcoming.PosterUpcoming


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


        viewModel.requestTrending()
        viewModel.requestUpcoming()

        return binding.root
    }

    private fun observeUpcoming() {
        viewModel.upcomingResponseList.observe(viewLifecycleOwner) {
            adapterUpcoming.setDataUpcoming(it)
        }
    }

    private fun setListUpcoming() {
        binding.rvUpcoming.setHasFixedSize(true)
        binding.rvUpcoming.adapter = adapterUpcoming
        adapterUpcoming.onClickListener= object : OnClickItemUpcoming{
            override fun onClick(posterUpcoming: PosterUpcoming) {
                navigationToDetailUpcoming(posterUpcoming)
            }
        }
    }

    private fun observeTrending() {
        viewModel.trendingResponseList.observe(viewLifecycleOwner) {
            adapterTrending.setDataTrending(it)
        }
    }

    private fun setListTrending() {
        binding.rvTrending.setHasFixedSize(true)
        binding.rvTrending.adapter = adapterTrending
        adapterTrending.onClickListener = object : OnClickItemTrending{
            override fun onClick(posterTrending: PosterTrending) {
                navigationToDetailTrending(posterTrending)
            }
        }
    }

    private fun navigationToDetailTrending(posterTrending: PosterTrending){
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("id", posterTrending.id)
        startActivity(intent)
    }

    private fun navigationToDetailUpcoming(posterUpcoming: PosterUpcoming){
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("id", posterUpcoming.id)
        startActivity(intent)
    }
}


