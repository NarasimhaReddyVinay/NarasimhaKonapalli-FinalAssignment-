package com.example.narasimhakonapalli_finalassignment.view.Favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentFavouriteBinding


class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding: FragmentFavouriteBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavouriteBinding.inflate(layoutInflater)

        return binding.root
    }


}