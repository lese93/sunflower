package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.placeholder.PlaceholderContent

class MyGardenFragment : Fragment() {

    var recyclerView : View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recyclerView = inflater.inflate(R.layout.fragment_mygarden_list, container, false)

        // Set the adapter
        recyclerView?.let {
            if (it is RecyclerView) {
                with(it) {
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = MyGardenRecyclerViewAdapter(PlaceholderContent.myGardenList)
                }
            }
        }

        return recyclerView
    }

    override fun onResume() {
        super.onResume()
        recyclerView?.let {
            if (it is RecyclerView) {
                with(it) {
                    adapter?.notifyDataSetChanged()
                }
            }
        }

    }



}