package com.example.myapplication.placeholder

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.Plant


object PlaceholderContent {

    val myGardenList = mutableListOf<Plant>()
    val liveData : MutableLiveData<List<Plant>> = MutableLiveData(myGardenList)
    val plantList = mutableListOf<Plant>()


}