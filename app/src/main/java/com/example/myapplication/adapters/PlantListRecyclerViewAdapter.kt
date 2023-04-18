package com.example.myapplication.adapters


import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.Added
import com.example.myapplication.PlantListViewHolder
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.FragmentPlantlistBinding


class PlantListRecyclerViewAdapter(
    private val values: List<Plant>,
    private val addedCallbacks: Added
) : RecyclerView.Adapter<PlantListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListViewHolder {

        return PlantListViewHolder(
            FragmentPlantlistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: PlantListViewHolder, position: Int) {
        holder.bind(values[position], position)
    }

    override fun getItemCount(): Int = values.size
}