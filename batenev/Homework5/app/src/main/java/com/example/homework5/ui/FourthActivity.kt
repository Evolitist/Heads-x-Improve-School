package com.example.homework5.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityFourthBinding
import java.text.SimpleDateFormat

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)

        with(binding) {

            intent.getLongExtra(SYSTEM_TIME, 0L).takeIf { it != 0L }?.let {
                tvIntentDateTime.text = getTimeFromUnixEpoch(it)
            }

            btnGoToFourthActivityAgain.setOnClickListener {
                startActivity(
                    Intent(
                        this@FourthActivity,
                        FourthActivity::class.java
                    ).putExtra(SYSTEM_TIME, System.currentTimeMillis())
                )
            }
        }

        setContentView(binding.root)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.getLongExtra(SYSTEM_TIME, 0).takeIf { it != 0L }?.let {
            binding.tvIntentDateTime.text = getTimeFromUnixEpoch(it)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTimeFromUnixEpoch(time: Long) =
        SimpleDateFormat("dd.MM.yy kk:mm:ss").format(time)

    companion object {
        const val SYSTEM_TIME = "system_time"
    }
}