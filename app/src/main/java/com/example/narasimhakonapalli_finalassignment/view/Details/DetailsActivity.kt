package com.example.narasimhakonapalli_finalassignment.view.Details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.narasimhakonapalli_finalassignment.adapter.CastAdapter
import com.example.narasimhakonapalli_finalassignment.data.RepositoryImpl
import com.example.narasimhakonapalli_finalassignment.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {

    private val adapterCast: CastAdapter by lazy {
        CastAdapter()
    }

    private val id: Int by lazy {
        intent.getIntExtra("id", 0)
    }

    private lateinit var binding: ActivityDetailsBinding

    private val viewModel: DetailsViewModle by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DetailsViewModle(RepositoryImpl()) as T
            }
        }.create(DetailsViewModle::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListCast()
        observeCast()

        viewModel.requestCast(id)

    }

    private fun observeCast() {
        viewModel.castResponseList.observe(this, {
            adapterCast.setDataCast(it)
        })
    }

    private fun setListCast() {
        binding.rvCast.setHasFixedSize(true)
        binding.rvCast.adapter = adapterCast
    }
}