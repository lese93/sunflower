package com.example.myapplication

import com.example.myapplication.data.Plant

class MyGardenRepository {
    private val mygardenData = mutableListOf<Plant>()

    fun addPlantMyGarden(data : Plant) {
        mygardenData.add(data)
    }

}