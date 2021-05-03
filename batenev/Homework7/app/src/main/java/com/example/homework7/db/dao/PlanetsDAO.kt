package com.example.homework7.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework7.db.model.PlanetDBModel

@Dao
interface PlanetsDAO {
    @Query("SELECT * FROM planets")
    suspend fun getAll(): List<PlanetDBModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(planets: List<PlanetDBModel>)

    @Query("SELECT COUNT(*) FROM planets")
    suspend fun getCount(): Int
}