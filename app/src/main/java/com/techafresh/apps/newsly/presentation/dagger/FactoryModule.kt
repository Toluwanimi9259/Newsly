package com.techafresh.apps.newsly.presentation.dagger

import android.app.Application
import com.techafresh.apps.newsly.domain.usecases.GetNewsFeedUseCase
import com.techafresh.apps.newsly.domain.usecases.GetTrendingNewsUseCase
import com.techafresh.apps.newsly.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideFactory(app: Application , getTrendingNewsUseCase: GetTrendingNewsUseCase , getNewsFeedUseCase: GetNewsFeedUseCase) : NewsViewModelFactory{
        return NewsViewModelFactory(app ,getNewsFeedUseCase , getTrendingNewsUseCase)
    }
}