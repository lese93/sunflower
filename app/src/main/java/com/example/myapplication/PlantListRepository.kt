package com.example.myapplication
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.Plant
import com.example.myapplication.data.PlantDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PlantListRepository constructor(private val plantDAO: PlantDAO) {

    val liveData: MutableLiveData<List<Plant>> = MutableLiveData(mutableListOf())

    suspend fun addPlantData(data: Plant) {
        withContext(Dispatchers.IO) {
            plantDAO.insert(data)
        }
        Log.e("insertData","" + data)
    }

    suspend fun getPlantByName(name: String): List<Plant> {
        return withContext(Dispatchers.IO) {
            plantDAO.getPlantByName(name)
        }
    }
    suspend fun init() {
        val plantData = withContext(Dispatchers.IO) {
            plantDAO.getAll()
        }
        Log.e("getAllData","" + plantData)
        liveData.value = plantData
    }

    fun get() : List<Plant> {
        return liveData.value?: mutableListOf()
    }
}