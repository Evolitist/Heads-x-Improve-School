package com.example.homework_8_retrofit_swapi.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework_8_retrofit_swapi.db.entities.DBModelVehicles

@Dao
interface VehiclesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVehicles(items: List<DBModelVehicles>)

    @Query("SELECT * FROM vehicles")
    suspend fun getAllVehicles(): List<DBModelVehicles>

    @Query("SELECT * from vehicles where model like :desc")
    suspend fun getSearchResultsVehicles(desc: String): List<DBModelVehicles>

    @Query("DELETE FROM vehicles")
    suspend fun removeAllVehicles()
}