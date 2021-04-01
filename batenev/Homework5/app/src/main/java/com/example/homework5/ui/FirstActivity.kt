package com.example.homework5.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.homework5.R
import com.example.homework5.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)

        with(binding) {
            btnGoToFourthActivity.setOnClickListener {
                startActivity(
                    Intent(
                        this@FirstActivity,
                        FourthActivity::class.java,
                    ).putExtra(FourthActivity.SYSTEM_TIME, System.currentTimeMillis())
                )
            }

            btnGoToSecondActivity.setOnClickListener {
                startActivity(
                    Intent(
                        this@FirstActivity,
                        SecondActivity::class.java,
                    )
                )
            }
        }


        setContentView(binding.root)
    }
}