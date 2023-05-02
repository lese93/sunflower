package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MyGardenRepository
import com.example.myapplication.PlantListRepository

import com.example.myapplication.data.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InformationViewModel @Inject constructor(private val plantListRepository: PlantListRepository,
                                               private val myGardenRepository: MyGardenRepository) : ViewModel() {

    fun addMyGardenPlant(data : Plant) {
        myGardenRepository.addPlantMyGarden(data)
    }

    fun getPlantList() : List<Plant> {
        return plantListRepository.get()
    }
}