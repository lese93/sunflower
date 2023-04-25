package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplication.adapters.ViewPagerAdapter
import com.example.myapplication.api.UnsplashAPI
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.placeholder.PlaceholderContent
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainViewpager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.mainViewpager) { tab, position ->
            if(position == 0) {
                tab.text = "MyGarden"
            } else {
                tab.text = "PlantList"
            }
        }.attach()
        init()
    }

    private fun init() {
        addPlants()
    }

    private fun addPlants() {
        GlobalScope.launch {
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
                val imageURL = unsplashResp.results[0].urls.small
                val description = unsplashResp.results[0].description
                val plantObject = Plant(
                    imageURL,
                    plant,
                    Random.nextInt(1, 11),
                    description ?: ""
                )
                PlaceholderContent.plantList.add(plantObject)
            }
        }
    }





}