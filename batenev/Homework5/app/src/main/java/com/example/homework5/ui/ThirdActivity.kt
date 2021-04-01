package com.example.homework5.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityThirdBinding
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        with(binding) {
            btnGoToFirstActivity.setOnClickListener {
                startActivity(
                    Intent(
                        this@ThirdActivity,
                        FirstActivity::class.java,
                    )
                )
            }

            btnGoToFifthActivity.setOnClickListener {
                startActivityForResult(
                    Intent(this@ThirdActivity, FifthActivity::class.java),
                    THIRD_ACTIVITY_REQUEST_CODE
                )
            }
        }

        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == THIRD_ACTIVITY_REQUEST_CODE) {
            data?.let {
                Snackbar.make(
                    binding.root,
                    it.getStringExtra(THIRD_ACTIVITY_RESULT_KEY) ?: "Error",
                    Snackbar.LENGTH_SHORT
                ).apply {
                    animationMode = Snackbar.ANIMATION_MODE_SLIDE
                }.show()
            }
        }
    }

    companion object {
        const val THIRD_ACTIVITY_REQUEST_CODE = 1
        const val THIRD_ACTIVITY_RESULT_KEY = "result"
    }
}