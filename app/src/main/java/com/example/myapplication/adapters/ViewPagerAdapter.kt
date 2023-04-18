package com.example.myapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.MyGardenFragment
import com.example.myapplication.PlantListFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    val fragments: List<Fragment>

    init {
        fragments = listOf(MyGardenFragment(), PlantListFragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position];
}