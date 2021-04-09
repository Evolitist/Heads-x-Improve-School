package com.evolitist.swapi.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PersonDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name", index = true) val name: String,
    @ColumnInfo(name = "height") val height: String,
    @ColumnInfo(name = "mass") val mass: String,
    @ColumnInfo(name = "hairColor") val hairColor: String,
    @ColumnInfo(name = "skinColor") val skinColor: String,
    @ColumnInfo(name = "eyeColor") val eyeColor: String,
    @ColumnInfo(name = "birthYear") val birthYear: String,
    @ColumnInfo(name = "gender") val gender: String,
)
