package com.example.myapplication.data;

import androidx.room.*

@Dao
interface PlantDAO {

    @Delete
    fun delete(plant: Plant)

    @Query("SELECT * FROM plant")
    fun getAll(): List<Plant>

    @Query("SELECT * FROM plant WHERE name = :plantName")
    fun getPlantByName(plantName: String): List<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(plant: Plant)
}
