package com.example.homework5.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        with(binding) {
            btnGoToThirdActivity.setOnClickListener {
                startActivity(
                    Intent(
                        this@SecondActivity,
                        ThirdActivity::class.java,
                    )
                )
            }
        }


        setContentView(binding.root)
    }
}