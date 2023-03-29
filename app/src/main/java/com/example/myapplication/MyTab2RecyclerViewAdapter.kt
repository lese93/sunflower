package com.example.myapplication


import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.databinding.FragmentTab1Binding

import com.example.myapplication.databinding.FragmentTab2Binding
import com.example.myapplication.placeholder.PlaceholderContent

class MyTab2RecyclerViewAdapter(
    private val values: List<Plant>,
    private val addedCallbacks: Added
) : RecyclerView.Adapter<Item2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item2ViewHolder {

        return Item2ViewHolder(
            FragmentTab2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: Item2ViewHolder, position: Int) {
        holder.bind(values[position], position)
    }

    override fun getItemCount(): Int = values.size
}