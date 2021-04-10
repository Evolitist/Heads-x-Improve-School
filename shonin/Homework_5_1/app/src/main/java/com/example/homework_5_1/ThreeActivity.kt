package com.example.homework_5_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_5_1.databinding.ActivityThreeBinding
import com.google.android.material.snackbar.Snackbar

class ThreeActivity : AppCompatActivity() {

    companion object {
        const val FIVE_ACTIVITY_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        val binding = ActivityThreeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val goMainActivity = Intent(this, MainActivity::class.java)
        val goFiveActivity = Intent(this, FiveActivity::class.java)

        binding.btnGoTo1.setOnClickListener { startActivity(goMainActivity) }
        binding.btnGoTo5.setOnClickListener {
            startActivityForResult(goFiveActivity, Companion.FIVE_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val binding = ActivityThreeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (requestCode === Companion.FIVE_ACTIVITY_REQUEST_CODE) {
            if (resultCode === Activity.RESULT_OK) {
                val returnString = data?.getStringExtra("MESSAGE")
                if (returnString != null) {
                    Snackbar.make(binding.root, returnString, Snackbar.LENGTH_SHORT).show()
                };
            }
        }

        val goMainActivity = Intent(this, MainActivity::class.java)
        val goFiveActivity = Intent(this, FiveActivity::class.java)

        binding.btnGoTo1.setOnClickListener { startActivity(goMainActivity) }
        binding.btnGoTo5.setOnClickListener {
            startActivityForResult(goFiveActivity, Companion.FIVE_ACTIVITY_REQUEST_CODE)
        }
    }


}