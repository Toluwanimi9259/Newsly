package com.techafresh.apps.newsly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article
import com.techafresh.apps.newsly.databinding.NewsFeedBinding
import com.techafresh.apps.newsly.databinding.TrendingNewsBinding

class TrendingAdapter(private val trendingNews : List<Article>) : RecyclerView.Adapter<TrendingAdapter.TViewHolder>(){

    inner class TViewHolder(private val binding: TrendingNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article){
            Glide.with(binding.imageViewTrending.context).load(article.urlToImage).into(binding.imageViewTrending)
            binding.titleTextViewTrending.text = article.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TViewHolder {
        val binding = TrendingNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TViewHolder, position: Int) {
       holder.bind(trendingNews[position])
    }

    override fun getItemCount(): Int = trendingNews.size
}