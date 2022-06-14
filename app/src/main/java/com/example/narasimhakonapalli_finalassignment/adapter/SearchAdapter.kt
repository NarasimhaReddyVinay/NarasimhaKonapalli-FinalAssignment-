package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemSearch
import com.example.narasimhakonapalli_finalassignment.databinding.ListSearchBinding
import com.example.narasimhakonapalli_finalassignment.model.search.SearchMovie
import com.example.narasimhakonapalli_finalassignment.util.Constant

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var list: MutableList<SearchMovie> = mutableListOf()
    var onClickItemSearch: OnClickItemSearch?= null


    inner class SearchViewHolder(private val binding: ListSearchBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(searchMovie: SearchMovie){

            binding.txtSearchTitle.text = searchMovie.title

            Glide.with(itemView)
                .load("${Constant.URL_IMAGE}${searchMovie.posterPath}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivSearch)

            itemView.setOnClickListener {
                onClickItemSearch?.onClick(searchMovie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= SearchViewHolder(
    ListSearchBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataSearch(data: List<SearchMovie>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}