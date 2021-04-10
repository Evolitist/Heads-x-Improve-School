package com.example.homework_5_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_5_1.databinding.ActivityFiveBinding


class FiveActivity : AppCompatActivity() {

    var data: Data = Data(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)

        val binding = ActivityFiveBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState != null) {
            data = savedInstanceState.getParcelable<Data>("data")!!
            binding.textView4.text = data.value
        }

        binding.deliverResult.setOnClickListener {
            val stringToPassBack: String = binding.editText.text.toString()
            val intent: Intent = Intent()
            intent.putExtra("MESSAGE", stringToPassBack)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.btnSave.setOnClickListener {
            val string: String
            string = binding.editText2.text.toString()
            binding.textView4.text = string
            data.value = string
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("data", data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val binding = ActivityFiveBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        data = savedInstanceState?.getParcelable<Data>("data")!!
        binding.textView4.text = data.value
    }
}