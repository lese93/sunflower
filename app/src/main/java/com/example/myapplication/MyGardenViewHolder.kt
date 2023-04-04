package com.example.myapplication

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.api.UnsplashAPI
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.FragmentMygardenBinding

class MyGardenViewHolder(val binding: FragmentMygardenBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val imageView: ImageView = binding.image
    val plantNameView: TextView = binding.plantName
    val plantedDateView: TextView = binding.plantedDate
    val lastWateredDateView: TextView = binding.lastWateredDate
    val wateringFrequencyView: TextView = binding.wateringFrequency

    fun bind(data: Plant, position: Int) {

        Glide.with(binding.root).load(data.imageUrl).into(imageView)
        plantNameView.text = data.name
        wateringFrequencyView.text = data.wateringFrequency.toString()

        binding.root.setOnClickListener {
            val intent = Intent(it.context, InformationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("position", position)
            it.context.applicationContext.startActivity(intent)
            Toast.makeText(it.context, "${data.imageUrl}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun toString(): String {
        return super.toString() + " '" + plantNameView.text + "'"
    }
}