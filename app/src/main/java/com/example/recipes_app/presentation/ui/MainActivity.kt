package com.example.recipes_app.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.recipes_app.R
import com.example.recipes_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment_container)
        if (!viewModel.isBoardingShowed()) navController.navigate(R.id.navigation_on_boarding)
        initViews(navController)
    }

    private fun initViews(navController: NavController) {
        val navBottomMenu: BottomNavigationView = binding.bottomMenu

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_search,
                R.id.navigation_library,
                R.id.navigation_cook,
                R.id.navigation_menu_page
            )
        )
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_on_boarding) {
                navBottomMenu.isVisible = false
                supportActionBar?.hide()
            } else {
                navBottomMenu.isVisible = true
                supportActionBar?.hide()
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navBottomMenu.setupWithNavController(navController)
    }

}