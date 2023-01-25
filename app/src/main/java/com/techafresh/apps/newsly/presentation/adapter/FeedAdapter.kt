package com.techafresh.apps.newsly.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.Article
import com.techafresh.apps.newsly.databinding.NewsFeedBinding

class FeedAdapter(private val newsFeed : List<Article>) : RecyclerView.Adapter<FeedAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsFeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsFeed[position])
    }

    override fun getItemCount(): Int = newsFeed.size

    inner class ViewHolder(private val binding: NewsFeedBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(article: Article){
            val url : String = article.urlToImage
            binding.newsFeedTitle.text = article.title
            Glide.with(binding.newsFeedPoster.context).load(article.urlToImage).into(binding.newsFeedPoster)
            binding.newsFeedSource.text = getSource(article.title)
            binding.newsFeedReadTime.text = "<3 min read"
        }

        private fun getSource(title : String):String{
            val index = title.lastIndexOf('-') + 2
            return title.substring(index)
        }
    }

}