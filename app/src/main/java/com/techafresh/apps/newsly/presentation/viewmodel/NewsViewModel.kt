package com.techafresh.apps.newsly.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.techafresh.apps.newsly.data.retrofit.dataClasses.feed.Article
import com.techafresh.apps.newsly.domain.usecases.GetNewsFeedUseCase
import com.techafresh.apps.newsly.domain.usecases.GetTrendingNewsUseCase
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app : Application,
    private val getNewsFeedUseCase: GetNewsFeedUseCase,
    private val getTrendingNewsUseCase: GetTrendingNewsUseCase
) : ViewModel(){

    val newsFeedLiveData = MutableLiveData<List<Article>>()
    val trendingNewsLiveData  = MutableLiveData<List<com.techafresh.apps.newsly.data.retrofit.dataClasses.trending.Article>>()

    fun getTrendingNews(keyword : String) = viewModelScope.launch {
        val trendingNews = getTrendingNewsUseCase.execute(keyword)
        if (isNetworkAvailable(app)){
            trendingNewsLiveData.postValue(trendingNews)
        }else{
           Log.d("MYTAG", "Internet Connection Problem")
        }
    }

    fun getNewsFeed(country: String) = viewModelScope.launch {
        val newsFeed = getNewsFeedUseCase.execute(country)
        if (isNetworkAvailable(app)){
            newsFeedLiveData.postValue(newsFeed)
        }else{
            Log.d("MYTAG", "Internet Connection Problem")
        }
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