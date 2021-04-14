package com.example.task8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.task8.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val navController = findNavController(R.id.container)
        binding.bottomNav.setupWithNavController(navController)

        binding.toolbar.setupWithNavController(navController, AppBarConfiguration(
                setOf(
                        R.id.SmallShipFragment,
                        R.id.SmallFilmFragment,
                        R.id.SmallPlanetFragment
                )
        ))

    }
}
