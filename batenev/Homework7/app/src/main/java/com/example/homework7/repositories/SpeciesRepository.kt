package com.example.homework7.repositories

import com.example.homework7.db.dao.SpeciesDAO
import com.example.homework7.mappers.toDbModel
import com.example.homework7.mappers.toUiModel
import com.example.homework7.network.SpeciesApiService
import com.example.homework7.network.utils.ApiResponse
import com.example.homework7.ui.species.model.SpeciesUiModel
import javax.inject.Inject
import kotlin.math.ceil

class SpeciesRepository @Inject constructor(
    private val dao: SpeciesDAO,
    private val apiService: SpeciesApiService
) {

    private var speciesCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageSize = 10

    suspend fun getSpecies(): DatasourceResult<List<SpeciesUiModel>> {
        if (pageCount == 0) {
            val dbCount = dao.getCount()
            if (dbCount > 0) {
                currentPage = ceil(dbCount / pageSize.toDouble()).toInt()
                pageCount = currentPage
                return DatasourceResult.Data(dao.getAll().toUiModel())
            }
        }
        return when (val response = apiService.getSpeciesPage(currentPage + 1)) {
            is ApiResponse.Success -> {
                if (speciesCount == 0) {
                    speciesCount = response.data.count
                    pageCount = ceil((speciesCount / pageSize.toDouble())).toInt()
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