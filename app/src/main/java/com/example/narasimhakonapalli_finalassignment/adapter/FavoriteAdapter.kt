package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.narasimhakonapalli_finalassignment.databinding.ListFavoriteBinding
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemFavorite
import com.example.narasimhakonapalli_finalassignment.util.Constant
import com.example.narasimhakonapalli_finalassignment.model.favorite.FavoriteEntity

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var list: MutableList<FavoriteEntity> = mutableListOf()
    var onClickItemFavorite: OnClickItemFavorite? = null

    inner class FavoriteViewHolder(private val binding: ListFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteEntity: FavoriteEntity) {

            itemView.setOnClickListener {
                onClickItemFavorite?.onClick(favoriteEntity)
            }

            binding.cbFavList.isChecked = true

                binding.cbFavList.setOnClickListener {
                onClickItemFavorite?.onClickFav(favoriteEntity)
            }

            Glide.with(itemView)
                .load("${Constant.URL_IMAGE}${favoriteEntity.posterPath}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivDetailFav)

            binding.txtTitleFavorite.text = favoriteEntity.originalTitle
            binding.txtYearFavorite.text = favoriteEntity.releaseDate

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoriteViewHolder (
    ListFavoriteBinding.inflate(
    LayoutInflater.from(parent.context),
    parent,
    false)
    )

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataFavorite(data: List<FavoriteEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}