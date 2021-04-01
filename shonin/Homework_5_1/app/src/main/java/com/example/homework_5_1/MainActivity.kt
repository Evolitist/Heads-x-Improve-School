package com.example.homework_5_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homework_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val goTwoActivity = Intent(this, TwoActivity::class.java)
        val goFourActivity = Intent(this, FourActivity::class.java)

        binding.btnGoTo2.setOnClickListener { startActivity(goTwoActivity) }
        binding.btnGoTo4.setOnClickListener {
            goFourActivity.putExtra(FourActivity.CURRENT_TIME, System.currentTimeMillis())
            startActivity(goFourActivity)
        }
    }
}