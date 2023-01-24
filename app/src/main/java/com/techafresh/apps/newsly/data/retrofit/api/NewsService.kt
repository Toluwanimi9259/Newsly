package com.techafresh.apps.newsly.data.retrofit.api

import com.techafresh.apps.newsly.BuildConfig
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.NewsFeed
import com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.TrendingFeed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    // newsapi.org/v2/everything?q=trending&apiKey=91f6a48694c8469789c4bdd181c480ff

    @GET("v2/everything")
    suspend fun getTrendingNews(
        @Query("q")
        keyword : String,

        @Query("apiKey")
        apiKey : String = BuildConfig.API_KEY
    ) : Response<TrendingFeed>

    @GET("v2/top-headlines")
    suspend fun getNewsFeed(
        @Query("country")
        country : String,

        @Query("apiKey")
        apiKey : String = BuildConfig.API_KEY
    ) : Response<NewsFeed>
}