package com.example.task8.ui.main.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.network.SWApiService
import com.example.task8.network.films.FilmApiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor (
    private val apiService: SWApiService,
) : ViewModel() {

    val errors = MutableSharedFlow<String>()
    val films = MutableLiveData<List<FilmApiModel>>()

    fun getFilms() = viewModelScope.launch {
        try {
            films.value = apiService.getFilms(1).results
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            errors.emit(e.toString())
        }
    }
}