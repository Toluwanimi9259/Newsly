package com.techafresh.apps.newsly.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.techafresh.apps.newsly.MainActivity
import com.techafresh.apps.newsly.R
import com.techafresh.apps.newsly.databinding.FragmentHomeBinding
import com.techafresh.apps.newsly.presentation.adapter.FeedAdapter
import com.techafresh.apps.newsly.presentation.adapter.TrendingAdapter
import com.techafresh.apps.newsly.presentation.viewmodel.NewsViewModel


class HomeFragment : Fragment() {

    private lateinit var newsFeedAdapter: FeedAdapter

    private lateinit var trendingAdapter: TrendingAdapter

    private lateinit var viewModel: NewsViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        viewModel = (activity as MainActivity).newsViewModel

        getNewsFeed()
        getTrendingNews()
    }

    private fun initNewsFeedRecyclerView(){
        binding.newsFeedRV.apply {
            adapter = newsFeedAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun getNewsFeed(){
        viewModel.getNewsFeed("ng")
        viewModel.newsFeedLiveData.observe(viewLifecycleOwner , Observer {
            newsFeedAdapter = FeedAdapter(it)
            initNewsFeedRecyclerView()
        })
    }

    private fun initTrendingNewsRecyclerView(){
        binding.trendingRV.apply {
            adapter = trendingAdapter
            layoutManager = StaggeredGridLayoutManager(1 , StaggeredGridLayoutManager.HORIZONTAL)
        }
    }

    fun getTrendingNews(){
        viewModel.getTrendingNews("trending")
        viewModel.trendingNewsLiveData.observe(viewLifecycleOwner , Observer {
            trendingAdapter = TrendingAdapter(it)
            initTrendingNewsRecyclerView()
        })
    }
}