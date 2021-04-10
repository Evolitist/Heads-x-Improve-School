package com.example.homework_5_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homework_5_1.databinding.ActivityFourBinding
import java.text.SimpleDateFormat

class FourActivity : AppCompatActivity() {

    companion object {
        const val CURRENT_TIME = "current_time"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)

        val binding = ActivityFourBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val goFourActivity = Intent(this, FourActivity::class.java)

        val currentTime = intent.getLongExtra(CURRENT_TIME, 0)
        val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
        val formatted = formatter.format(currentTime)
        binding.dataview.text = formatted

        binding.btnGoTo4Again.setOnClickListener {
            goFourActivity.putExtra(CURRENT_TIME, System.currentTimeMillis())
            onNewIntent(goFourActivity)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        val goFourActivity = Intent(this, FourActivity::class.java)

        val binding = ActivityFourBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (intent != null) {
            val currentTime = intent.getLongExtra(CURRENT_TIME, 0)
            val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
            val formatted = formatter.format(currentTime)
            binding.dataview.text = formatted
        }

        binding.btnGoTo4Again.setOnClickListener {
            goFourActivity.putExtra(CURRENT_TIME, System.currentTimeMillis())
            onNewIntent(goFourActivity)
        }
    }
}