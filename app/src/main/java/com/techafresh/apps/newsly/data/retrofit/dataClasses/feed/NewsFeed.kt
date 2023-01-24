package com.techafresh.apps.newsly.data.retrofit.dataClasses.feed


import com.google.gson.annotations.SerializedName

data class NewsFeed(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)