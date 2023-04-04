package com.example.myapplication

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.FragmentPlantlistBinding
import com.example.myapplication.placeholder.PlaceholderContent

class PlantListViewHolder(val binding: FragmentPlantlistBinding) : RecyclerView.ViewHolder(binding.root) {
    val imageView: ImageView = binding.image
    val plantNameView: TextView = binding.plantName

    fun bind(data: Plant, position: Int) {
        Glide.with(binding.root).load(PlaceholderContent.plantList[position].imageUrl).into(imageView)
        plantNameView.text = data.name
        binding.root.setOnClickListener {
            val intent = Intent(it.context, InformationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("position", position)
            it.context.applicationContext.startActivity(intent)
        }

    }

    override fun toString(): String {
        return super.toString() + " '" + plantNameView.text + "'"
    }
}