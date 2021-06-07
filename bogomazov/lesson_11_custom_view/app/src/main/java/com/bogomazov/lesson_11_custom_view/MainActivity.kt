package com.bogomazov.lesson_11_custom_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val check = findViewById<ViewGraph>(R.id.viewGraphCheck)
        check.listPointUser = mutableListOf(0.4F, 0.4F, 0.4F, 0.4F, 0.4F)
        findViewById<Button>(R.id.button).setOnClickListener {
            check.getRandomPoint()
        }
    }
}