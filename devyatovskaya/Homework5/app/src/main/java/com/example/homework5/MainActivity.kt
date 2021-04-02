package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val secondActivity = Intent(this, ActivityTwo::class.java)

        binding.button1to2.setOnClickListener { startActivity(secondActivity) }
        binding.button1to4.setOnClickListener {
            startActivity(ActivityFour.launchIntent(this, System.currentTimeMillis()))
        }
    }
}