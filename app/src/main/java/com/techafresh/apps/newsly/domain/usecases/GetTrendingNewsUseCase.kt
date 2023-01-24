package com.techafresh.apps.newsly.domain.usecases

import com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article
import com.techafresh.apps.newsly.domain.repository.Repository

class GetTrendingNewsUseCase(private val repository: Repository) {
    suspend fun execute(keyword : String) : List<Article> = repository.getTrendingNews(keyword)
}