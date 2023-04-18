package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import com.example.myapplication.MyGardenRepository
import com.example.myapplication.data.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyGardenViewModel @Inject constructor(private val myGardenRepo: MyGardenRepository) :
    ViewModel() {


    fun loadMyGardenData(): List<Plant> {
        return myGardenRepo.get()
    }
}