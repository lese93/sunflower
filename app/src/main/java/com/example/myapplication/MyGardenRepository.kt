package com.example.myapplication

import com.example.myapplication.data.Plant
import com.example.myapplication.data.PlantDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Room (SQL) 과 SharedPreference
class MyGardenRepository constructor(
    private val plantDAO: PlantDAO
) {
    private val mygardenData = mutableListOf<Plant>()

    fun addPlantMyGarden(data: Plant) {
        // Plant Table의 data.name의 favorite이 1로 바꾼다
        GlobalScope.launch(Dispatchers.IO) {
            plantDAO.updateFavorite(data.name, 1)
        }
        mygardenData.add(data)
    }

    fun get(): List<Plant> {
        // Plant Table의 favorite이 1인 데이터만 들고오면
        GlobalScope.launch(Dispatchers.IO) {
            val favoritePlants = plantDAO.getFavoritePlants()
            mygardenData.clear()
            if (favoritePlants != null) {
                mygardenData.addAll(favoritePlants)
            }
        }

        return mygardenData
    }
}

// Plant Table
/**
name | desc | water | image url | favorite
apple / delicious / 3 / http~blahblah~ / 1
MyGarden
name | desc | water | iamge url
 **/