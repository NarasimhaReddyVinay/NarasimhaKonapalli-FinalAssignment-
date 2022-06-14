package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.narasimhakonapalli_finalassignment.databinding.ListCastBinding
import com.example.narasimhakonapalli_finalassignment.util.Constant
import com.example.narasimhakonapalli_finalassignment.model.cast.Cast

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private var list: MutableList<Cast> = mutableListOf()

    inner class CastViewHolder(private val binding: ListCastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cast: Cast) {

            Glide.with(itemView)
                .load("${Constant.URL_IMAGE}${cast.profile}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(binding.ivCast)
            binding.txtNameCast.text = cast.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CastViewHolder (
        ListCastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
            )

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataCast(data: List<Cast>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}