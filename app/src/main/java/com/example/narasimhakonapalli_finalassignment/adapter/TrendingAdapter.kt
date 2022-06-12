package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.narasimhakonapalli_finalassignment.R
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemTrending
import com.example.narasimhakonapalli_finalassignment.model.Trending.PosterTrending
import com.squareup.picasso.Picasso

class TrendingAdapter: RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    private var list: MutableList<PosterTrending> = mutableListOf()
    var onClickListener: OnClickItemTrending? =null

    inner class TrendingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(posterTrending: PosterTrending){

            val TrendingImage = itemView.findViewById<ImageView>(R.id.iv_trending)

            Picasso.get()
                .load(posterTrending.posterPath)
                .fit()
                .into(TrendingImage)

            itemView.setOnClickListener {
                onClickListener?.onClick(posterTrending)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_trending, parent, false)
        return TrendingViewHolder(view)
    }

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