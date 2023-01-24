package com.techafresh.apps.newsly.data.repository.datasourceImpl

import com.techafresh.apps.newsly.data.repository.datasource.RemoteDataSource
import com.techafresh.apps.newsly.data.retrofit.api.NewsService
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.NewsFeed
import com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.TrendingFeed
import retrofit2.Response

class RemoteDataSourceImpl(private val newsService: NewsService) : RemoteDataSource {

    override suspend fun getTrendingNews(keyword: String): Response<TrendingFeed> = newsService.getTrendingNews(keyword)

    override suspend fun getNewsFeed(country: String): Response<NewsFeed> = newsService.getNewsFeed(country)

}