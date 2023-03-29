package com.example.myapplication

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentTab1Binding
import com.example.myapplication.placeholder.PlaceholderContent

class MyTab1RecyclerViewAdapter(
    private val values: List<Plant>,
    private val addedCallbacks: Added
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(
            FragmentTab1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(values[position], position)
    }

    override fun getItemCount(): Int = values.size
}