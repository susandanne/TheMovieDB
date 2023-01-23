package com.example.themoviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.databinding.ItemMovieBinding
import com.example.themoviedb.model.MovieResult
import com.example.themoviedb.ui.Util

class Adapterlang:PagingDataAdapter<MovieResult,Adapterlang.LangViewholder>(comparator) {


    inner class LangViewholder( val itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root){

        }

    companion object {
        private val comparator = object : DiffUtil.ItemCallback<MovieResult>() {
            override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: LangViewholder, position: Int) {
        getItem(position).let {

            Glide.with(holder.itemMovieBinding.root.context)
                .load(Util.posterUrlMake(it?.posterPath))
                .into(holder.itemMovieBinding.image)
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LangViewholder {

            val binding =
                ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return LangViewholder(binding)

        }

}