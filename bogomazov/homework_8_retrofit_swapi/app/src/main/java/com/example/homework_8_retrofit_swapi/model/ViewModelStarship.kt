package com.example.homework_8_retrofit_swapi.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_8_retrofit_swapi.db.ClientDatabase
import com.example.homework_8_retrofit_swapi.db.entities.DBModelStarship
import com.example.homework_8_retrofit_swapi.network.data.DataList
import com.example.homework_8_retrofit_swapi.network.data.starship.StarshipData
import com.example.homework_8_retrofit_swapi.network.service.SwapiApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ViewModelStarship @Inject constructor(
    private val database: ClientDatabase,
    private val apiSwapi: SwapiApiService
) : ViewModel() {

    val starshipsDB = MutableLiveData<List<DBModelStarship>>()

    private fun getAllStarship(): Flow<List<StarshipData>> = flow {
        if (database.starshipsDao().getAllStarship().isEmpty()) {
            var next: String?
            var starship: DataList<StarshipData>
            var i = 0
            do {
                starship = apiSwapi.getCurrentStarship(++i)
                next = starship.next
                emit(starship.results)
            } while (next != null)
        }
    }

    fun getStarship() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.starshipsDao().getAllStarship().isEmpty()) {
                getAllStarship().collect { starship ->
                    database.starshipsDao().insertAllStarship(
                        starship.map {
                            TypeChangeModule.getStarshipInDB(it)
                        }
                    )
                }
            }
            val dataDB = database.starshipsDao().getAllStarship()
            withContext(Dispatchers.Main) {
                starshipsDB.value = dataDB
            }
        }
    }

    fun searchStarshipInDB(disc: String) {
        val searchQuery = "%$disc%"
        viewModelScope.launch(Dispatchers.IO) {
            val dataSearch = database.starshipsDao().getSearchResultsStarships(searchQuery)
            withContext(Dispatchers.Main) {
                starshipsDB.value = dataSearch
            }
        }
    }

    fun removeDbStarship() {
        viewModelScope.launch(Dispatchers.IO) {
            database.starshipsDao().removeAllStarships()
        }
    }
}