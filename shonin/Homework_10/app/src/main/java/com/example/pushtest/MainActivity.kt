package com.example.pushtest

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.pushtest.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create


class MainActivity : AppCompatActivity() {

    private val apiService: ApiService = ApiService.Factory.provideRetrofit().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            GlobalScope.launch {
                apiService.sensAll()
            }

        }
    }
}