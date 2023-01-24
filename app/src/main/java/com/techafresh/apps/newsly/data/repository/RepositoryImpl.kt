package com.techafresh.apps.newsly.data.repository

import com.techafresh.apps.newsly.data.repository.datasource.RemoteDataSource
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.Article
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.NewsFeed
import com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.TrendingFeed
import com.techafresh.apps.newsly.domain.repository.Repository
import retrofit2.Response

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {


    override suspend fun getTrendingNews(keyword: String): List<com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article> {
        val response : Response<TrendingFeed> = remoteDataSource.getTrendingNews(keyword)
        val trendingNews : List<com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article> = response.body()!!.articles
        return trendingNews
    }

    override suspend fun getNewsFeed(country: String): List<Article> {
        val response : Response<NewsFeed> = remoteDataSource.getNewsFeed(country)
        val newsFeed : List<Article> = response.body()!!.articles
        return newsFeed
    }
}