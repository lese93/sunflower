package com.example.myapplication

import com.example.myapplication.data.Plant
import javax.inject.Inject

// Room (SQL) 과 SharedPreference
class MyGardenRepository {
    private val mygardenData = mutableListOf<Plant>()

    fun addPlantMyGarden(data : Plant) {
        mygardenData.add(data)
    }

    fun get() : List<Plant> {
        return mygardenData
    }

}