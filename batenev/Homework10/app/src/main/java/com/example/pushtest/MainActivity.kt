package com.example.pushtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pushtest.data.MessageData
import com.example.pushtest.data.TokenData
import com.example.pushtest.databinding.ActivityMainBinding
import com.example.pushtest.network.Api
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (!it.isSuccessful) {
                return@addOnCompleteListener
            }
            val token = it.result
            lifecycleScope.launch {
                val response = Api.apiService.sendToken(
                    TokenData(
                        "Kakava",
                        token ?: "No token for you today"
                    )
                )
            }
        }

        with(binding) {
            btnSend.setOnClickListener {
                lifecycleScope.launch {
                    val response = Api.apiService.sendMessage(
                        MessageData(
                            etName.text.toString(),
                            etMessage.text.toString()
                        )
                    )
                }
            }
        }
    }
}
