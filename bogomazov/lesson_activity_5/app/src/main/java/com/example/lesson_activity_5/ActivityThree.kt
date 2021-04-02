package com.example.lesson_activity_5


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_activity_5.databinding.ActivityThreeBinding
import com.google.android.material.snackbar.Snackbar

class ActivityThree : AppCompatActivity() {

    //А если я внутри класса это делаю утечки памяти не будет?
    //Посидел на форумах вроде нет и плюс так пишет гугл в документации
    private lateinit var binding: ActivityThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstActivity = Intent(this, MainActivity::class.java)
        val fifeActivity = Intent(this, ActivityFife::class.java)

        binding.goFirstActivity.setOnClickListener {
            startActivity(firstActivity)
        }

        binding.goFifeActivity.setOnClickListener {
            startActivityForResult(fifeActivity, Constants.RESULT_OK)
        }

        fun snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
            Snackbar.make(binding.root, message, duration).show()
        }

    }

    private fun snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
        Snackbar.make(binding.root, message, duration).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Constants.RESULT_OK) {
            val text = data?.getStringExtra(Constants.SEND_MESSAGE).toString()
            snack(text)
        } else {
            snack("Error")
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}