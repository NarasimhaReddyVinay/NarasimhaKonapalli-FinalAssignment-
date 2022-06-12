package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.narasimhakonapalli_finalassignment.R
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemUpcoming
import com.example.narasimhakonapalli_finalassignment.model.upcoming.PosterUpcoming
import com.squareup.picasso.Picasso

class UpcomingAdapter: RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    private var list: MutableList<PosterUpcoming> = mutableListOf()
    var onClickListener: OnClickItemUpcoming? =null

    inner class UpcomingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(posterUpcoming: PosterUpcoming){


            val upcomingMovieTitle: TextView = itemView.findViewById(R.id.txt_title_favorite)
            val upcomingMoviedate: TextView = itemView.findViewById(R.id.txt_year_favorite)
            val UpcomingImage = itemView.findViewById<ImageView>(R.id.iv_detail_fav)

            upcomingMovieTitle.text = posterUpcoming.title
            upcomingMoviedate.text = posterUpcoming.releaseDate

            Picasso.get()
                .load(posterUpcoming.posterPath)
                .fit()
                .into(UpcomingImage)

            itemView.setOnClickListener {
                onClickListener?.onClick(posterUpcoming)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_upcoming, parent, false)
        return UpcomingViewHolder(view)
    }

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

