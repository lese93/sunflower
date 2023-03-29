package com.example.myapplication

import android.content.Intent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentTab2Binding

class Item2ViewHolder(val binding: FragmentTab2Binding) : RecyclerView.ViewHolder(binding.root) {
    val plantNameView: TextView = binding.plantName

    fun bind(data: Plant, position: Int) {

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