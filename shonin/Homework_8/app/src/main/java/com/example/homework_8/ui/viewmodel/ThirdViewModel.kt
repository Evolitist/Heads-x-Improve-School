package com.example.homework_8.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_8.api.PeopleRepository
import com.example.homework_8.db.MyDatabase
import com.example.homework_8.mapper.MyMapper
import com.example.homework_8.ui.model.Human
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    private val peopleRepository: PeopleRepository,
    database: MyDatabase,
) : ViewModel() {

    private val dao = database.dao()
    val people = MutableLiveData<List<Human>>()

    fun getPeople() {
        viewModelScope.launch {
            if (dao.countAllPeople() <= 1) {
                dao.insertAllPeople(peopleRepository.getAllPeople()
                    .reduce { accumulator, value -> accumulator + value }
                    .map(MyMapper::apiToDbHumanModel))
                people.value = dao.getAllPeople().map(MyMapper::dbToHumanModel)
            } else {
                people.value = dao.getAllPeople().map(MyMapper::dbToHumanModel)
            }

        }
    }

    fun delDb() {
        viewModelScope.launch {
            dao.removeAllPeople()
            people.value = emptyList()
        }
    }

    fun searchPeople(name: String) {
        viewModelScope.launch {
            people.value = dao.searchAllPeople("%" + name + "%").map(MyMapper::dbToHumanModel)
        }
    }

}