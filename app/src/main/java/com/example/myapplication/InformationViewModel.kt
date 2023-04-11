package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.myapplication.data.Plant


class InformationViewModel : ViewModel() {

    val repository : MyGardenRepository = MyGardenRepository()
    fun addPlant(data : Plant) {
        repository.addPlantMyGarden(data)
    }

}