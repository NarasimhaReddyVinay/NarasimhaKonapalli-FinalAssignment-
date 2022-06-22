package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.narasimhakonapalli_finalassignment.databinding.ListUpcomingBinding
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemUpcoming
import com.example.narasimhakonapalli_finalassignment.model.upcoming.PosterUpcoming
import com.example.narasimhakonapalli_finalassignment.util.Constant


class UpcomingAdapter: RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    private var list: MutableList<PosterUpcoming> = mutableListOf()
    var onClickListener: OnClickItemUpcoming? =null

    inner class UpcomingViewHolder(private val binding: ListUpcomingBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(posterUpcoming: PosterUpcoming){


            binding.txtTitleFavorite.text = posterUpcoming.title

            binding.txtYearFavorite.text = posterUpcoming.releaseDate


            val rating = posterUpcoming.rating
            binding.ratingBar.numStars = 5
            binding.ratingBar.stepSize = 0.5f
            binding.ratingBar.rating = rating/2

            Glide.with(itemView)
                .load("${Constant.URL_IMAGE}${posterUpcoming.posterPath}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivDetailFav)


            itemView.setOnClickListener {
                onClickListener?.onClick(posterUpcoming)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= UpcomingViewHolder(
        ListUpcomingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return if (list.size >= 8){
            8
        }else{
            list.size
        }
        }

    fun setDataUpcoming(data: List<PosterUpcoming>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}

