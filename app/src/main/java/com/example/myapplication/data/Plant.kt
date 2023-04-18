package com.example.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Plant(
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "watering_frequency") val wateringFrequency: Int,
    @ColumnInfo(name = "description") val description: String
)