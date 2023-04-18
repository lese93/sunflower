package com.example.myapplication

import com.example.myapplication.data.Plant

class PlantListRepository {
    private val plantListData = mutableListOf<Plant>()

    fun addPlantListData(data: Plant) {
        plantListData.add(data)
    }

    fun get(): List<Plant> {
        return plantListData
    }

}