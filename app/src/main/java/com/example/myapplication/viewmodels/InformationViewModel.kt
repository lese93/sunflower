package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import com.example.myapplication.MyGardenRepository

import com.example.myapplication.data.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class InformationViewModel @Inject constructor(private val repository: MyGardenRepository) : ViewModel() {
    fun addPlant(data : Plant) {
        repository.addPlantMyGarden(data)
    }

    fun get() : List<Plant> {
        return repository.get()
    }
}