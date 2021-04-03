package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Activity4 : AppCompatActivity() {

    private lateinit var resultTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)
        resultTv = findViewById(R.id.resultTv)

        getTimeFromArguments(intent)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = getLaunchIntent(this, System.currentTimeMillis())
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        getTimeFromArguments(intent)
    }

    private fun getTimeFromArguments(intent: Intent?) {
        val time = intent?.getLongExtra(ARG_TIME,0) ?: 0
        resultTv.text = "Дата: ${time.toDateTime()}"
    }

    fun Long.toDateTime(): String {
        return SimpleDateFormat.getDateTimeInstance().format(Date(this))
    }

    companion object {
        private const val ARG_TIME = "TIME"

        fun getLaunchIntent(context: Context, time: Long): Intent {
            return Intent(context, Activity4::class.java).apply {
                putExtra(ARG_TIME, time)
            }
        }
    }
}