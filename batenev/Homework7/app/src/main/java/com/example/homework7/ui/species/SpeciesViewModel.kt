package com.example.homework7.ui.species

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework7.ui.species.model.SpeciesUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpeciesViewModel @Inject constructor(

) : ViewModel() {

    private val _species = MutableLiveData<SpeciesUiModel>()
    val species: LiveData<SpeciesUiModel> = _species

    fun setData(item: SpeciesUiModel) {
        _species.value = item
    }
}