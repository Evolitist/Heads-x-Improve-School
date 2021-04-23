package com.example.homework_8_retrofit_swapi.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework_8_retrofit_swapi.db.entities.DBModelPlanets

@Dao
interface PlanetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlanets(item: List<DBModelPlanets>)

    @Query("SELECT * from planets")
    suspend fun getAllPlanets(): List<DBModelPlanets>

    @Query("SELECT * from planets where name like :desc")
    suspend fun getSearchResultsPlanets(desc: String): List<DBModelPlanets>

    @Query("DELETE FROM planets")
    suspend fun removeAllPlanets()

}