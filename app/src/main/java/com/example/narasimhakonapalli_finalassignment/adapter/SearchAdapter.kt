package com.example.narasimhakonapalli_finalassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemSearch
import com.example.narasimhakonapalli_finalassignment.R
import com.example.narasimhakonapalli_finalassignment.model.search.SearchMovie
import com.squareup.picasso.Picasso

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var list: MutableList<SearchMovie> = mutableListOf()
    var onClickItemSearch: OnClickItemSearch?= null


    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(searchMovie: SearchMovie){

            val movieTitle: TextView = itemView.findViewById(R.id.txt_search_title)
            val movieImage = itemView.findViewById<ImageView>(R.id.iv_search)


            movieTitle.text = searchMovie.title
            Picasso.get()
                .load(searchMovie.logo_path)
                .fit()
                .into(movieImage)

            itemView.setOnClickListener {
                onClickItemSearch?.onClick(searchMovie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_search, parent, false)
        return SearchViewHolder(view)
    }

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