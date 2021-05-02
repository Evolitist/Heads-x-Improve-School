package com.example.pushtest.service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushtest.models.RegisterToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: ServicePost
) : ViewModel(){

    fun sendToken(username: String, token: String) {
        viewModelScope.launch {
            apiService.registerToken(RegisterToken(username, token))
        }
    }
}