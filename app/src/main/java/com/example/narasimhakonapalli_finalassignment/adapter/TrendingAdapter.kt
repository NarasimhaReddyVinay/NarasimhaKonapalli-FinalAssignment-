package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.narasimhakonapalli_finalassignment.databinding.ListTrendingBinding
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemTrending
import com.example.narasimhakonapalli_finalassignment.model.Trending.PosterTrending
import com.example.narasimhakonapalli_finalassignment.util.Constant

class TrendingAdapter: RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    private var list: MutableList<PosterTrending> = mutableListOf()
    var onClickListener: OnClickItemTrending? =null

    inner class TrendingViewHolder(private val binding: ListTrendingBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(posterTrending: PosterTrending){


            Glide.with(itemView)
                .load("${Constant.URL_IMAGE}${posterTrending.posterPath}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivTrending)


            itemView.setOnClickListener {
                onClickListener?.onClick(posterTrending)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= TrendingViewHolder(
        ListTrendingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
    )

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataTrending(data: List<PosterTrending>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}