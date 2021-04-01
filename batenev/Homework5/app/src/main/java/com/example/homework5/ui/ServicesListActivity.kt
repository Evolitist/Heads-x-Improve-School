package com.example.homework5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5.R
import com.example.homework5.databinding.ActivityServicesListBinding

class ServicesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServicesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServicesListBinding.inflate(layoutInflater)

        with(binding) {
            recyclerView
        }

        setContentView(binding.root)
    }
}