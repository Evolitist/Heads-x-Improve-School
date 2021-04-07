package com.example.homework6.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.homework6.R
import com.example.homework6.databinding.ActivityMainBinding
import com.example.homework6.ui.common.OnViewPagerItemClickedListener
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnViewPagerItemClickedListener {

    private lateinit var binding: ActivityMainBinding

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val navController = navHostFragment.navController
        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.firstFragment,
                R.id.secondFragment,
                R.id.thirdFragment,
                R.id.fourthFragment
            )
        )

        binding.bottomNavigationView.setupWithNavController(navController)
        binding.toolbar.setupWithNavController(navController, appBarConfig)



        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
    }

    override fun onItemClicked(text: String) {
        Snackbar.make(
            binding.root,
            text,
            Snackbar.LENGTH_SHORT
        ).apply {
            animationMode = Snackbar.ANIMATION_MODE_SLIDE
        }.show()
    }
}