package com.example.homework5.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.homework5.databinding.ActivityFifthBinding
import data.Data

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFifthBinding.inflate(layoutInflater)

        savedInstanceState?.let { bundle ->
            bundle.getParcelable<Data>(DATA_FIELD)?.let {
                binding.tvDataField.text = it.value
            }
        }

        with(binding) {
            btnDeliverResult.setOnClickListener {
                setActivityResult()
            }

            btnSave.setOnClickListener {
                if (etResultField.text.isNotEmpty()) {
                    tvDataField.text = etResultField.text
                }
            }
        }

        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        binding.etResultField.text.takeIf { it.isNotEmpty() }?.let {
            outState.putAll(
                bundleOf(DATA_FIELD to Data(it.toString()))
            )
        }
        super.onSaveInstanceState(outState)
    }

    private fun setActivityResult() {
        with(binding) {
            if (etResultField.text.isNotEmpty()) {
                setResult(
                    Activity.RESULT_OK,
                    Intent().putExtra(
                        ThirdActivity.THIRD_ACTIVITY_RESULT_KEY,
                        etResultField.text.toString()
                    )
                )
                finish()
            }
        }
    }

    companion object {
        private const val DATA_FIELD = "data_field"
    }
}