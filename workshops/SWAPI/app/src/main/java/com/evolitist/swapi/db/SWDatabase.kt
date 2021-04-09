package com.evolitist.swapi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.evolitist.swapi.db.model.PersonDbModel

@Database(entities = [PersonDbModel::class], version = 1)
abstract class SWDatabase : RoomDatabase() {

    abstract fun dao(): SWDao

    companion object {

        fun getInstance(context: Context): SWDatabase {
            return Room.databaseBuilder(context, SWDatabase::class.java, "appdb")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
