package com.techafresh.apps.newsly.domain.usecases

import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.Article
import com.techafresh.apps.newsly.domain.repository.Repository

class GetNewsFeedUseCase(private val repository: Repository) {
    suspend fun execute(country : String) : List<Article> = repository.getNewsFeed(country)
}