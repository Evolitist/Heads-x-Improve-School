package com.example.lesson_activity_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_activity_5.databinding.ActivityFifeBinding

class ActivityFife : AppCompatActivity() {

    private lateinit var binding: ActivityFifeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun sendText() {
            val dataText = binding.editTextText.text

            if (dataText.isBlank() || dataText.isEmpty()) {
                setResult(Constants.ERROR)
            } else {
                intent.putExtra(Constants.SEND_MESSAGE, dataText.toString())
                setResult(Constants.RESULT_OK, intent)
            }
        }

        binding.goFirstActivity.setOnClickListener {
            sendText()
            finish()
        }

        binding.textViewDataClass.text = dataActivityFife.string

        fun saveText(): DataClass {
            val dataText = binding.editTextData.text

            if (dataText.isBlank() || dataText.isEmpty()) {
                dataActivityFife.string = "Error"
            } else {
                dataActivityFife.string = dataText.toString()
            }
            return dataActivityFife
        }

        binding.buttonSendData.setOnClickListener {
            binding.textViewDataClass.text = saveText().string
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(Constants.SAVE_DATA, dataActivityFife)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val objData = savedInstanceState.getParcelable<DataClass>(Constants.SAVE_DATA)
        if (objData != null)
            binding.textViewDataClass.text = objData?.string
        super.onRestoreInstanceState(savedInstanceState)
    }


}