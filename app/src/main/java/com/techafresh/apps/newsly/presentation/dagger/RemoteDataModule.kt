package com.techafresh.apps.newsly.presentation.dagger

import com.techafresh.apps.newsly.data.repository.datasource.RemoteDataSource
import com.techafresh.apps.newsly.data.repository.datasourceImpl.RemoteDataSourceImpl
import com.techafresh.apps.newsly.data.retrofit.api.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(newsService: NewsService) : RemoteDataSource{
        return RemoteDataSourceImpl(newsService)
    }
}