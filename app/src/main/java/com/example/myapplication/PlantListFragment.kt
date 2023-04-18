package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myapplication.adapters.PlantListRecyclerViewAdapter
import com.example.myapplication.viewmodels.PlantListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlantListFragment : Fragment(), Added {
    //
    private val viewModel by viewModels<PlantListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_plantlist_list, container, false)
        viewModel.loadPlantsData()
        // Set the adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            if (view is RecyclerView) {
                with(view) {
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = PlantListRecyclerViewAdapter(it, this@PlantListFragment)
                }
            }
        }
        return view
    }

    override fun onAdded() {
        Log.e("Added", "onAdded")
    }
}