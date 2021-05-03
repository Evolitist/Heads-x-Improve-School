package com.example.homework7.ui.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework7.ui.planets.model.PlanetUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(

) : ViewModel() {

    private val _planet = MutableLiveData<PlanetUiModel>()
    val planet: LiveData<PlanetUiModel> = _planet

    fun setData(item: PlanetUiModel) {
        _planet.value = item
    }

}