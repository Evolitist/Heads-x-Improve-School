package com.example.pushtest.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushtest.network.RetrofitModel
import com.example.pushtest.network.data.MessageData
import com.example.pushtest.network.data.StatusData
import com.example.pushtest.network.data.UserData
import kotlinx.coroutines.launch

class ViewModelMain : ViewModel() {
    private val retrofit = RetrofitModel.retrofitService()
    val status = MutableLiveData<StatusData>()

    fun sendInfoUser(user: UserData) {
        viewModelScope.launch {
            status.value = retrofit.requestDataUser(user)
        }
    }

    fun sendMessage(message: MessageData) {
        viewModelScope.launch {
            status.value = retrofit.requestMessage(message)
        }
    }
}