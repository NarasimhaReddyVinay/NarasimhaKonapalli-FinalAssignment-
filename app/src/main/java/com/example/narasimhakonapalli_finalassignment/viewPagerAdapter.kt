package com.example.narasimhakonapalli_finalassignment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.narasimhakonapalli_finalassignment.view.Favourite.FavouriteFragment
import com.example.narasimhakonapalli_finalassignment.view.Home.HomeFragment
import com.example.narasimhakonapalli_finalassignment.view.search.SearchFragment


class viewPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> HomeFragment()
            1 -> FavouriteFragment()
            2 -> SearchFragment()
            else -> {
                HomeFragment()
            }
        }
    }
}