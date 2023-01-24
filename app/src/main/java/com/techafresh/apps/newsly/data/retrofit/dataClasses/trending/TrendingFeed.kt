package com.techafresh.apps.newsly.data.retrofit.dataClasses.trending


import com.google.gson.annotations.SerializedName

data class TrendingFeed(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)