package com.techafresh.apps.newsly.presentation.dagger

import com.techafresh.apps.newsly.data.repository.RepositoryImpl
import com.techafresh.apps.newsly.data.repository.datasource.RemoteDataSource
import com.techafresh.apps.newsly.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides

    fun provideRepository(remoteDataSource: RemoteDataSource) : Repository{
        return RepositoryImpl(remoteDataSource)
    }
}