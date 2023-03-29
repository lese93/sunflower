package com.example.myapplication.placeholder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Plant
import java.util.ArrayList
import java.util.HashMap


object PlaceholderContent {

    val myGardenList = mutableListOf<Plant>()
    val liveData : MutableLiveData<List<Plant>> = MutableLiveData(myGardenList)
    val plantList = listOf<Plant>(
        Plant("", "Apple", 3, "Apple is Delicious"),
        Plant("", "Avocado", 4, "Avocado is oily"),
        Plant("", "Beet", 5, "Beet is bitter")
    )


}