package com.example.task8.ui.main.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.network.Planets.PlanetApiModel
import com.example.task8.network.SWApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor (
    private val apiService: SWApiService,
) : ViewModel() {

    val errors = MutableSharedFlow<String>()
    val planets = MutableLiveData<List<PlanetApiModel>>()

    fun getPlanets() = viewModelScope.launch {
        try {
            planets.value = apiService.getPlanets(1).results
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            errors.emit(e.toString())
        }
    }
}