package com.example.homework_8.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class HumanDBModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val birthYear: String,
    @ColumnInfo val eyeColor: String,
    @ColumnInfo val gender: String,
    @ColumnInfo val height: String,
    @ColumnInfo val mass: String,
    @ColumnInfo val skinColor: String,
    @ColumnInfo val hairColor: String,
    @ColumnInfo val created: String,
    @ColumnInfo val edited: String,
)
