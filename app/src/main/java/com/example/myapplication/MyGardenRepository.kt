package com.example.myapplication

import com.example.myapplication.data.Plant
import com.example.myapplication.data.PlantDAO

// Room (SQL) 과 SharedPreference
class MyGardenRepository constructor(
    private val plantDAO: PlantDAO
) {
    private val mygardenData = mutableListOf<Plant>()

    fun addPlantMyGarden(data: Plant) {
        mygardenData.add(data)
    }

    fun get(): List<Plant> {
        return mygardenData
    }

}