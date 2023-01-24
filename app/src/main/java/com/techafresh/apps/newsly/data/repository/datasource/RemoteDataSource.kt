package com.techafresh.apps.newsly.data.repository.datasource

import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.NewsFeed
import com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.TrendingFeed
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getTrendingNews(keyword : String) : Response<TrendingFeed>

    suspend fun getNewsFeed(country : String) : Response<NewsFeed>
}