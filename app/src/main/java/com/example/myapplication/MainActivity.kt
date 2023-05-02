package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.adapters.ViewPagerAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


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
    }
}