package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityInformationBinding
import com.example.myapplication.placeholder.PlaceholderContent

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    val plantList = listOf<Plant>(
        Plant("", "Apple", 3, "Apple is Delicious"),
        Plant("", "Avocado", 4, "Avocado is oily"),
        Plant("", "Beet", 5, "Beet is bitter")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", -1)

        binding.name.text = plantList[position].name
        binding.desc.text = plantList[position].description
        binding.btnPrevious.setOnClickListener{
            finish()
        }
        binding.btnAdd.setOnClickListener{
            PlaceholderContent.myGardenList.add(plantList[position])
        }
    }
}