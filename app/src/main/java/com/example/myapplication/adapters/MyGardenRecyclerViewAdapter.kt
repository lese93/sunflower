package com.example.myapplication.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.MyGardenViewHolder
import com.example.myapplication.data.Plant
import com.example.myapplication.databinding.FragmentMygardenBinding

class MyGardenRecyclerViewAdapter(
    private val values: List<Plant>
) : RecyclerView.Adapter<MyGardenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGardenViewHolder {

        return MyGardenViewHolder(
            FragmentMygardenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyGardenViewHolder, position: Int) {
        holder.bind(values[position], position)
    }

    override fun getItemCount(): Int = values.size
}