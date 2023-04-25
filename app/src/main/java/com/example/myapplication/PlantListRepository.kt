package com.example.myapplication
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.Plant
import com.example.myapplication.data.PlantDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PlantListRepository constructor(private val plantDAO: PlantDAO) {
    private val plantListData = plantDAO.getAll()
    val liveData: MutableLiveData<List<Plant>> = MutableLiveData(plantListData)

    suspend fun addPlantData(data: Plant) {
        withContext(Dispatchers.IO) {
            plantDAO.insert(data)
        }
    }
    fun get(): List<Plant> {
        return plantListData
    }
}