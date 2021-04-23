package com.example.hw6

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hw6.databinding.ActivityMainBinding
import com.example.hw6.ui.viewpager.OnViewPagerItemClickListener
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnViewPagerItemClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val navController = findNavController(R.id.container)
        binding.bottomNav.setupWithNavController(navController)

        binding.toolbar.setupWithNavController(
            navController, AppBarConfiguration(
                setOf(
                    R.id.fragmentFirst,
                    R.id.fragmentSecond,
                    R.id.fragmentThird,
                    R.id.fragmentFour
                )
            )
        )
        setSupportActionBar(binding.toolbar)
    }

    override fun onItemClick(text: String) {
        Snackbar.make(
            binding.root,
            text,
            Snackbar.LENGTH_SHORT
        ).apply {
            animationMode = Snackbar.ANIMATION_MODE_SLIDE
        }.show()
    }
}