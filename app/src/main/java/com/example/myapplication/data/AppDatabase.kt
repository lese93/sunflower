package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Plant::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plantDAO(): PlantDAO
}