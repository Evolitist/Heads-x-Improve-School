package com.example.homework_8.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetDBModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val rotationPeriod: String,
    @ColumnInfo val orbitalPeriod: String,
    @ColumnInfo val diameter: String,
    @ColumnInfo val climate: String,
    @ColumnInfo val gravity: String,
    @ColumnInfo val terrain: String,
    @ColumnInfo val surfaceWater: String,
    @ColumnInfo val population: String,
    @ColumnInfo val created: String,
    @ColumnInfo val edited: String,
)