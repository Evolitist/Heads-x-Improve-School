package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityFiveBinding

class ActivityFive : AppCompatActivity() {

    var data: Data = Data(null)
    private lateinit var binding:ActivityFiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)
        binding = ActivityFiveBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        savedInstanceState?.let { bundle ->
            bundle.getParcelable<Data>(DATA_STRING)?.let {
                binding.text.text = it.value
            }
        }
        binding.deliverresult.setOnClickListener {
            val stringToPassBack: String = binding.editText.text.toString()
            val intent: Intent = Intent()
            intent.putExtra(ActivityThree.THIRD_ACTIVITY_RESULT, stringToPassBack)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.save.setOnClickListener {
            val string: String = binding.editText.text.toString()
            binding.text.text = string
            data.value = string
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(DATA_STRING, data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding = ActivityFiveBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        data = savedInstanceState?.getParcelable(DATA_STRING)!!
        binding.text.text = data.value
    }


    companion object{
        val DATA_STRING = "data"
    }
}