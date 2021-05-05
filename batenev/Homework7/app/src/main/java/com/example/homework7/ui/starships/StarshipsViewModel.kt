package com.example.homework7.ui.starships

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework7.ui.starships.model.StarshipUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarshipsViewModel @Inject constructor(

) : ViewModel() {

    private val _starship = MutableLiveData<StarshipUiModel>()
    val starship: LiveData<StarshipUiModel> = _starship

    fun setData(item: StarshipUiModel) {
        _starship.value = item
    }
}