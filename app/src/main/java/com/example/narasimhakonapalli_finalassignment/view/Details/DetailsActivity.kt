package com.example.narasimhakonapalli_finalassignment.view.Details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.narasimhakonapalli_finalassignment.data.RepositoryImpl
import com.example.narasimhakonapalli_finalassignment.databinding.ActivityDetailsBinding
import com.example.narasimhakonapalli_finalassignment.model.details.DetailResponse
import com.example.narasimhakonapalli_finalassignment.util.Constant.URL_IMAGE


class DetailsActivity : AppCompatActivity() {


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

        navigationBack()
        observeDetailMovie()

        viewModel.requestDetailMovie(id)

    }

    private fun navigationBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
    private fun observeDetailMovie(){
        viewModel.detailResponse.observe(this, {
            loadPoster(it)
            loadDetail(it)

        })
    }



    private fun loadPoster(detailResponse: DetailResponse) {
        Glide.with(this)
            .load("$URL_IMAGE${detailResponse.backdropPath}")
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.ivPoster)
    }

    private fun loadDetail(detailResponse: DetailResponse) {
        binding.txtTitleDetail.text = detailResponse.originalTitle
        binding.txtReleaseDetail.text = detailResponse.releaseDate
        binding.txtGenreDetail.text = detailResponse.genres?.map { it?.name }!!.joinToString("-")
        binding.txtDescriptionDetail.text = detailResponse.overview
    }


}


