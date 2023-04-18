package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.MyGardenRecyclerViewAdapter
import com.example.myapplication.viewmodels.MyGardenViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MyGardenFragment : Fragment() {

    var recyclerView : View? = null

    private val viewModel by viewModels<MyGardenViewModel>()

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
                    adapter = MyGardenRecyclerViewAdapter(viewModel.loadMyGardenData())
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