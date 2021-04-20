package com.example.homework7.ui.common

import androidx.lifecycle.ViewModel
import com.example.homework7.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class SWViewModel @Inject constructor(
    private  val apiService: ApiService
) : ViewModel() {

    private var planetsCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageItemCount = 10
}