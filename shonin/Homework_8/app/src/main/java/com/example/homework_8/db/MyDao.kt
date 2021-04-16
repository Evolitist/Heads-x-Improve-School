package com.example.homework_8.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework_8.db.model.HumanDBModel
import com.example.homework_8.db.model.PlanetDBModel
import com.example.homework_8.db.model.StarshipDBModel

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllStarships(items: List<StarshipDBModel>)

    @Query("SELECT * FROM starships")
    suspend fun getAllStarships(): List<StarshipDBModel>

    @Query("SELECT * FROM starships WHERE name LIKE :item")
    suspend fun searchAllStarships(item: String): List<StarshipDBModel>

    @Query("SELECT COUNT(id) FROM starships")
    suspend fun countAllStarships(): Int

    @Query("DELETE FROM starships")
    suspend fun removeAllStarships()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlanets(items: List<PlanetDBModel>)

    @Query("SELECT * FROM planets")
    suspend fun getAllPlanets(): List<PlanetDBModel>

    @Query("SELECT * FROM planets WHERE name LIKE :item")
    suspend fun searchAllPlanets(item: String): List<PlanetDBModel>

    @Query("SELECT COUNT(id) FROM planets")
    suspend fun countAllPlanets(): Int

    @Query("DELETE FROM planets")
    suspend fun removeAllPlanets()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPeople(items: List<HumanDBModel>)

    @Query("SELECT * FROM people")
    suspend fun getAllPeople(): List<HumanDBModel>

    @Query("SELECT * FROM people WHERE name LIKE :item")
    suspend fun searchAllPeople(item: String): List<HumanDBModel>

    @Query("SELECT COUNT(id) FROM people")
    suspend fun countAllPeople(): Int

    @Query("DELETE FROM people")
    suspend fun removeAllPeople()
}
