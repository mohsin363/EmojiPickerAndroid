package com.mohsin.emojipicker.view.recyclerview

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BottomSheetPagesAdapter(fr: Fragment) : FragmentStateAdapter(fr) {

    private val fragmentList = mutableListOf<Fragment>()

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}