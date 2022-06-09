package com.example.narasimhakonapalli_finalassignment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.narasimhakonapalli_finalassignment.R
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentHomeBinding
import com.example.narasimhakonapalli_finalassignment.databinding.FragmentSearchBinding


class HomeFragment : Fragment() {



    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)


        return binding.root
    }


}