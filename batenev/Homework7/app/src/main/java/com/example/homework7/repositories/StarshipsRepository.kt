package com.example.homework7.repositories

import com.example.homework7.db.dao.StarshipsDAO
import com.example.homework7.mappers.toDbModel
import com.example.homework7.mappers.toUiModel
import com.example.homework7.network.StarshipsApiService
import com.example.homework7.network.utils.ApiResponse
import com.example.homework7.ui.starships.model.StarshipUiModel
import javax.inject.Inject
import kotlin.math.ceil

class StarshipsRepository @Inject constructor(
    private val dao: StarshipsDAO,
    private val apiService: StarshipsApiService
) {
    private var starshipsCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageSize = 10

    suspend fun getStarships(): DatasourceResult<List<StarshipUiModel>> {
        if (pageCount == 0) {
            val dbCount = dao.getCount()
            if (dbCount > 0) {
                currentPage = ceil(dbCount / pageSize.toDouble()).toInt()
                pageCount = currentPage
                return DatasourceResult.Data(dao.getAll().toUiModel())
            }
        }
        return when (val response = apiService.getStarshipsPage(currentPage + 1)) {
            is ApiResponse.Success -> {
                if (starshipsCount == 0) {
                    starshipsCount = response.data.count
                    pageCount = ceil((starshipsCount / pageSize.toDouble())).toInt()
                }
                currentPage++
                dao.insertAll(response.data.results.toDbModel())
                DatasourceResult.Data(response.data.results.toUiModel())
            }
            is ApiResponse.ApiError -> {
                if (response.code == 404) {
                    DatasourceResult.Error(DatasourceError.EMPTY)
                } else {
                    DatasourceResult.Error(DatasourceError.API)
                }
            }
            is ApiResponse.NetworkError -> {
                DatasourceResult.Error(DatasourceError.NETWORK)
            }
            is ApiResponse.UnknownError -> {
                DatasourceResult.Error(DatasourceError.UNKNOWN)
            }
            ApiResponse.Empty -> {
                DatasourceResult.Error(DatasourceError.EMPTY)
            }
        }
    }
}