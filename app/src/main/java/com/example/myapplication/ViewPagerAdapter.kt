package com.example.myapplication

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    val fragments: List<Fragment>

    init {
        fragments = listOf(Tab1Fragment(), Tab2Fragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position];
}