package com.techafresh.apps.newsly.presentation.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.Article
import com.techafresh.apps.newsly.domain.usecases.GetNewsFeedUseCase
import com.techafresh.apps.newsly.domain.usecases.GetTrendingNewsUseCase

class NewsViewModel(
    private val getNewsFeedUseCase: GetNewsFeedUseCase,
    private val getTrendingNewsUseCase: GetTrendingNewsUseCase
) : ViewModel(){

    val newsFeedLiveData = MutableLiveData<List<Article>>()
    val trendingNewsLiveData  = MutableLiveData<List<com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article>>()

    fun getTrendingNews(keyword : String) = liveData {
        emit(getTrendingNewsUseCase.execute(keyword))
    }

    fun getNewsFeedUseCase(country : String) = liveData {
        emit(getNewsFeedUseCase.execute(country))
    }




    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }
}