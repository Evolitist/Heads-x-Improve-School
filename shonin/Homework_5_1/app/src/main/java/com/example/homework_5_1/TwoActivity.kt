package com.example.homework_5_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_5_1.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val binding = ActivityTwoBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val goThreeActivity = Intent(this, ThreeActivity::class.java)

        binding.btnGoTo3.setOnClickListener { startActivity(goThreeActivity) }

    }
}