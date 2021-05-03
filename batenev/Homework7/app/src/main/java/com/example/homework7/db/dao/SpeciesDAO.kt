package com.example.homework7.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework7.db.model.SpeciesDBModel

@Dao
interface SpeciesDAO {

    @Query("SELECT * FROM species")
    suspend fun getAll(): List<SpeciesDBModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(species: List<SpeciesDBModel>)

    @Query("SELECT COUNT(*) FROM species")
    suspend fun getCount() : Int
}