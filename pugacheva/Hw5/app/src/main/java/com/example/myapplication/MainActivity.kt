package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //val nameEt = findViewById<EditText>(R.id.nameEt)

        val butGoTo4 = findViewById<Button>(R.id.goTo4)
        val butGoTo2 = findViewById<Button>(R.id.goTo2)

        butGoTo4.setOnClickListener {
            val time = System.currentTimeMillis()
            val intent = Intent(this@MainActivity, Activity4::class.java)
            intent.putExtra("TIME", time)
            startActivity(intent)
        }

        butGoTo2.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity2::class.java)
            startActivity(intent)
        }

    }
}