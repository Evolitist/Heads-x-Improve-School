package com.example.homework_8.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starships")
data class StarshipDBModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val model: String,
    @ColumnInfo val starshipClass: String,
    @ColumnInfo val manufacturer: String,
    @ColumnInfo val costInCredits: String,
    @ColumnInfo val length: String,
    @ColumnInfo val crew: String,
    @ColumnInfo val passengers: String,
    @ColumnInfo val maxAtmospheringSpeed: String,
    @ColumnInfo val hyperdriveRating: String,
    @ColumnInfo val MGLT: String,
    @ColumnInfo val cargoCapacity: String,
    @ColumnInfo val consumables: String,
    @ColumnInfo val created: String,
    @ColumnInfo val edited: String,
)


