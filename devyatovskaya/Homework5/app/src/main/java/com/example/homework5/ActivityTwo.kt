package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityTwoBinding

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val binding = ActivityTwoBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val thirdActivity = Intent(this, ActivityThree::class.java)
        binding.button2to3.setOnClickListener { startActivity(thirdActivity) }

    }
}