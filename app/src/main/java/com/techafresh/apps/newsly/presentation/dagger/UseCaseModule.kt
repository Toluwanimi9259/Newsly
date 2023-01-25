package com.techafresh.apps.newsly.presentation.dagger

import com.techafresh.apps.newsly.domain.repository.Repository
import com.techafresh.apps.newsly.domain.usecases.GetNewsFeedUseCase
import com.techafresh.apps.newsly.domain.usecases.GetTrendingNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsFeedUseCase(repository: Repository) : GetNewsFeedUseCase {
        return GetNewsFeedUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideTrendingNewsUseCase(repository: Repository) : GetTrendingNewsUseCase {
        return GetTrendingNewsUseCase(repository)
    }
}