package com.example.homework_8_retrofit_swapi.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework_8_retrofit_swapi.db.entities.DBModelStarship

@Dao
interface StarshipsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllStarship(items: List<DBModelStarship>)

    @Query("SELECT * FROM starship")
    suspend fun getAllStarship(): List<DBModelStarship>

    @Query("SELECT * from starship where model or name like  :desc")
    suspend fun getSearchResultsStarships(desc: String): List<DBModelStarship>

    @Query("DELETE FROM starship")
    suspend fun removeAllStarships()
}