package com.example.last_lesson

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.last_lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val l = try {
                floatArrayOf(
                    binding.editText1.text.toString().toFloat(),
                    binding.editText2.text.toString().toFloat(),
                    binding.editText3.text.toString().toFloat(),
                    binding.editText4.text.toString().toFloat(),
                    binding.editText5.text.toString().toFloat()
                )
            } catch (e: NumberFormatException) {
                floatArrayOf(0f, 0f, 0f, 0f, 0f)
            }
            binding.graphView.sett(l)

        }

        binding.buttonMin.setOnClickListener {
            binding.graphView.sett(floatArrayOf(-1f, -1f, -1f, -1f, -1f))
        }

        binding.buttonMax.setOnClickListener {
            binding.graphView.sett(floatArrayOf(1f, 1f, 1f, 1f, 1f))
        }
    }
}