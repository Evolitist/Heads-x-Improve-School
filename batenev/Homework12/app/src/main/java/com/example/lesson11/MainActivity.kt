package com.example.lesson11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import com.example.lesson11.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val list = mutableListOf<Float>()
            var value = 0F
            repeat(5) {
                value = Random.nextFloat()
                if (Random.nextBoolean()) value *= -1
                list.add(value)
            }
            binding.customView.setPoints(list)
        }

    }
}