package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplication.api.UnsplashAPI
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.placeholder.PlaceholderContent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainViewpager.adapter = ViewPagerAdapter(this)

        init()
        setupEvents()
    }

    private fun init() {
        setFragment(0)
        binding.tab1Txt.setTextColor(ContextCompat.getColor(this, R.color.yellow_1))
        binding.tab2Txt.setTextColor(ContextCompat.getColor(this, R.color.green_3))
        binding.line1.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        binding.line2.setBackgroundColor(ContextCompat.getColor(this, R.color.green_2))
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
                "Bougaivillea",
                "Cilantro",
                "Eggplant"
            )

            for (plant in plantList) {
                val unsplashResp = unsplashAPI.searchPhotos(plant, page, perPage)
                val imageURL = unsplashResp.results[0].urls.small
                val description = unsplashResp.results[0].description
                val plant = Plant(
                    imageURL,
                    plant,
                    Random.nextInt(1, 11),
                    description
                )
                PlaceholderContent.plantList.add(plant)
            }
        }
    }


    private fun setupEvents() {
        binding.tab1.setOnClickListener {
            setFragment(0)

            binding.tab1Txt.setTextColor(ContextCompat.getColor(this, R.color.yellow_1))
            binding.tab2Txt.setTextColor(ContextCompat.getColor(this, R.color.green_3))
            binding.line1.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            binding.line2.setBackgroundColor(ContextCompat.getColor(this, R.color.green_2))
        }

        binding.tab2.setOnClickListener {
            setFragment(1)
            binding.tab1Txt.setTextColor(ContextCompat.getColor(this, R.color.green_3))
            binding.tab2Txt.setTextColor(ContextCompat.getColor(this, R.color.yellow_1))
            binding.line1.setBackgroundColor(ContextCompat.getColor(this, R.color.green_2))
            binding.line2.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }


    }

    private fun setFragment(fragmentNum: Int) {
        when (fragmentNum) {
            0 -> {
                binding.mainViewpager.currentItem = 0
            }
            1 -> {
                binding.mainViewpager.currentItem = 1
            }
        }
    }
}