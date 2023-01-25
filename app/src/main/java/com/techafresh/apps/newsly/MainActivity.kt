package com.techafresh.apps.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.techafresh.apps.newsly.databinding.ActivityMainBinding
import com.techafresh.apps.newsly.presentation.viewmodel.NewsViewModel
import com.techafresh.apps.newsly.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory

    private lateinit var binding : ActivityMainBinding

    lateinit var newsViewModel: NewsViewModel

    lateinit var navHostFragment: NavHostFragment

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsViewModel = ViewModelProvider(this , factory)[NewsViewModel::class.java]

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        binding.bottomNavX.setupWithNavController(navController)
    }
}