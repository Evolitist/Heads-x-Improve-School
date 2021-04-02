package com.example.homework5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityFourBinding
import java.text.SimpleDateFormat

class ActivityFour : AppCompatActivity() {

    private val binding by lazy {
        ActivityFourBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getLongExtra(CURRENT_TIME, 0).let {
            binding.showtime.text = styleTime(it)
        }

        binding.button4again.setOnClickListener {
            val intent = launchIntent(this, System.currentTimeMillis())
            startActivity(intent)
        }
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        intent?.getLongExtra(CURRENT_TIME, 0).let {
            binding.showtime.text = it?.let { it1 -> styleTime(it1) }
        }
    }

    private fun styleTime(currentTime: Long) =
        SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(currentTime)

    companion object {
        private const val CURRENT_TIME = "current_time"

        fun launchIntent(context: Context, currentTime: Long): Intent {
            return Intent(context, ActivityFour::class.java).apply {
                putExtra(CURRENT_TIME, currentTime)
            }
        }
    }
}