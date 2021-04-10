package com.example.lesson_activity_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lesson_activity_5.databinding.ActivityFourBinding
import java.text.SimpleDateFormat


class ActivityFour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getLongExtra(Constants.SYSTEM_TIME, 0)
        binding.textTime.text = SimpleDateFormat(DATA_FORMAT).format(message)

        fun sendTime() {
            intent.putExtra(Constants.SYSTEM_TIME, System.currentTimeMillis())
            startActivity(intent)
        }

        binding.goFourActivity.setOnClickListener {
            sendTime()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val message = intent?.getLongExtra(Constants.SYSTEM_TIME, 0)
        //как в эту функцию прокинуть binding?
        findViewById<TextView>(R.id.textTime).text = SimpleDateFormat(DATA_FORMAT).format(message)
    }

    companion object{
        const val DATA_FORMAT = "EEE, d MMM yyyy HH:mm:ss"
    }

}