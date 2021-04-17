package com.example.task8.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmDbModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "episodeId") val episodeId: Int,
    @ColumnInfo(name = "director") val director: String,
    @ColumnInfo(name = "producer") val producer: String,
    @ColumnInfo(name = "openingCrawl") val openingCrawl: String
)
