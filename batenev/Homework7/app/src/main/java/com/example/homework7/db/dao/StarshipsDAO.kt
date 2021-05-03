package com.example.homework7.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework7.db.model.StarshipDBModel

@Dao
interface StarshipsDAO {

    @Query("SELECT * FROM starships")
    suspend fun getAll(): List<StarshipDBModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(starships: List<StarshipDBModel>)

    @Query("SELECT COUNT(*) FROM starships")
    suspend fun getCount(): Int
}