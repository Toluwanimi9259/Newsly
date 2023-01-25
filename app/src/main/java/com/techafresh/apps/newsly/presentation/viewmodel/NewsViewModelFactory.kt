package com.techafresh.apps.newsly.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techafresh.apps.newsly.domain.usecases.GetNewsFeedUseCase
import com.techafresh.apps.newsly.domain.usecases.GetTrendingNewsUseCase

class NewsViewModelFactory(
    private val app : Application,
    private val getNewsFeedUseCase: GetNewsFeedUseCase,
    private val getTrendingNewsUseCase: GetTrendingNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, getNewsFeedUseCase, getTrendingNewsUseCase) as T
    }
}