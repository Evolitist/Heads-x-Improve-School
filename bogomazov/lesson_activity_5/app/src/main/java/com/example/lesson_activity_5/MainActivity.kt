package com.example.lesson_activity_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.lesson_activity_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val secondActivity = Intent(this, ActivitySecond::class.java)
        val fourActivity = Intent(this, ActivityFour::class.java)

        fun sendTime() {
            fourActivity.putExtra(Constants.SYSTEM_TIME, System.currentTimeMillis())
            startActivity(fourActivity)
        }

        binding.goSecondActivity.setOnClickListener {
            startActivity(secondActivity)
        }

        binding.goFourActivity.setOnClickListener {
            sendTime()
        }

    }
}

object Constants {
    const val SYSTEM_TIME = "system.time.millis"
    const val RESULT_OK = 200
    const val ERROR = 405
    const val SEND_MESSAGE = "send.message.text.edit"
    const val SAVE_DATA = "save.data"
}
