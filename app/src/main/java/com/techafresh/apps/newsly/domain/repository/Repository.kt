package com.techafresh.apps.newsly.domain.repository




interface Repository {

    suspend fun getTrendingNews(keyword : String) : List<com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article>

    suspend fun getNewsFeed(country : String) : List<com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.Article>
}