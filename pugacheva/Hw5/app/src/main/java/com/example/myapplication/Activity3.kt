package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class Activity3 : AppCompatActivity() {

    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        rootView = findViewById(R.id.rootView)
        val butGoTo5 = findViewById<Button>(R.id.goTo5)
        val butGoTo1 = findViewById<Button>(R.id.goTo1)

        butGoTo5.setOnClickListener {
            val intent = Intent(this, Activity5::class.java)
            startActivityForResult(intent,2)
        }
        butGoTo1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2 && resultCode == RESULT_OK){
            val snacText = data?.getStringExtra("MESSAGE") ?: return
            Snackbar.make(rootView, snacText, Snackbar.LENGTH_SHORT).show()
        }
    }
}