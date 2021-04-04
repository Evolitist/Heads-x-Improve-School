package com.example.homework5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityThreeBinding
import com.google.android.material.snackbar.Snackbar

class ActivityThree : AppCompatActivity() {

    private lateinit var binding : ActivityThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(LayoutInflater.from(this))

        val mainActivity = Intent(this, MainActivity::class.java)
        val fifthActivity = Intent(this, ActivityFive::class.java)

        binding.button3to1.setOnClickListener { startActivity(mainActivity) }
        binding.button3to5.setOnClickListener {
            startActivityForResult(fifthActivity,  THIRD_ACTIVITY_REQUEST_CODE)
        }
        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == THIRD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                Snackbar.make(
                        binding.root,
                        it.getStringExtra(THIRD_ACTIVITY_RESULT) ?: "Error",
                        Snackbar.LENGTH_SHORT
                ).apply {
                    animationMode = Snackbar.ANIMATION_MODE_SLIDE
                }.show()
            }
        }
    }

    companion object {
        const val THIRD_ACTIVITY_REQUEST_CODE = 1
        const val THIRD_ACTIVITY_RESULT = "result"
    }
}