package com.example.myapplication

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentTab1Binding

class ItemViewHolder(val binding: FragmentTab1Binding) : RecyclerView.ViewHolder(binding.root) {

    val plantNameView: TextView = binding.plantName
    val plantedDateView: TextView = binding.plantedDate
    val lastWateredDateView: TextView = binding.lastWateredDate
    val wateringFrequencyView: TextView = binding.wateringFrequency

    fun bind(data: Plant, position: Int) {

        plantNameView.text = data.name
        wateringFrequencyView.text = data.wateringFrequency.toString()
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