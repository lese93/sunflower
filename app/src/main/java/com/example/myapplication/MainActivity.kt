package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainViewpager.adapter = ViewPagerAdapter(this)

        init()
        setEvents()
    }

    private fun init(){
        setFragment(0)
        binding.tab1Txt.setTextColor(ContextCompat.getColor(this, R.color.yellow_1))
        binding.tab2Txt.setTextColor(ContextCompat.getColor(this, R.color.green_3))
        binding.line1.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        binding.line2.setBackgroundColor(ContextCompat.getColor(this, R.color.green_2))
    }

    private fun setEvents(){
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