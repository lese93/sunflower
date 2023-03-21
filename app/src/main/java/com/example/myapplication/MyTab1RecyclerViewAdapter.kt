package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapplication.databinding.FragmentTab1Binding

class MyTab1RecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyTab1RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentTab1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentTab1Binding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}