package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.ActivityInformationBinding
import com.example.myapplication.placeholder.PlaceholderContent

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    val plantList = PlaceholderContent.plantList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", -1)

        Glide.with(this).load(plantList[position].imageUrl).into(binding.image)
        binding.name.text = plantList[position].name
        binding.desc.text = plantList[position].description
        binding.btnPrevious.setOnClickListener{
            finish()
        }
        binding.btnAdd.setOnClickListener{
            PlaceholderContent.myGardenList.add(plantList[position])
            Toast.makeText(this, "${plantList[position].name} 추가되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}