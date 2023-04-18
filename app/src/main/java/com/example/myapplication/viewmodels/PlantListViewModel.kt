package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.UnsplashAPI
import com.example.myapplication.data.Plant
import com.example.myapplication.notifyObserver
import kotlinx.coroutines.launch
import kotlin.random.Random

class PlantListViewModel : ViewModel() {
    // Plant List를 불러오는 역할
    // Plant list에서 Mygarden으로 추가하는 역할

    val plantData = mutableListOf<Plant>()
    val liveData: MutableLiveData<List<Plant>> = MutableLiveData(plantData)

    fun loadPlantsData() {
        viewModelScope.launch {
            val unsplashAPI = UnsplashAPI.create()

            val page = 1
            val perPage = 10
            val plantList = listOf(
                "Apple",
                "Avocado",
                "Beet",
                "Bougainvillea",
                "Cilantro",
                "Eggplant"
            )

            for (plant in plantList) {
                val unsplashResp = unsplashAPI.searchPhotos(plant, page, perPage)

                /// result = null
                /// result = []
                if (unsplashResp.results.isNotEmpty()) {
                    val imageURL = unsplashResp.results[0].urls.small
                    val description = unsplashResp.results[0].description

                    val newPlant = Plant(
                        imageURL,
                        plant,
                        Random.nextInt(1, 11),
                        description ?: ""
                    )
                    plantData.add(newPlant)
                }
            }

            liveData.notifyObserver()
        }
    }

}