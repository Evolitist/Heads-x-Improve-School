package com.example.lesson_activity_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_activity_5.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val threeActivity = Intent(this, ActivityThree::class.java)

        binding.goThreeActivity.setOnClickListener {
            startActivity(threeActivity)
        }

    }
}