package com.example.myapplication.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
interface PlantDao {

    @Delete
    fun delete(plant: Plant)

    @Query("SELECT * FROM plant")
    fun getAll(): List<Plant>

    @Query("SELECT * FROM plant WHERE name = :plantName")
    fun getPlantByName(plantName: String): List<Plant>
}
