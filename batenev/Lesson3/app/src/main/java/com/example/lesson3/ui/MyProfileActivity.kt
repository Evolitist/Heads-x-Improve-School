package com.example.lesson3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson3.R
import com.example.lesson3.databinding.ActivityMainBinding
import com.example.lesson3.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}