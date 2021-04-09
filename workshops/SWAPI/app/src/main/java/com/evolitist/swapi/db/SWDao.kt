package com.evolitist.swapi.db

import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.*
import com.evolitist.swapi.db.model.PersonDbModel

@Dao
interface SWDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<PersonDbModel>)

    @Query("SELECT * FROM people")
    fun getAll(): DataSource.Factory<Int, PersonDbModel>

    @Query("DELETE FROM people")
    suspend fun removeAll()
}
