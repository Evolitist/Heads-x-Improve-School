package com.example.hw6.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (
    fragment: Fragment,
    private val list: List<ViewPagerItem>,
    private val onItemClickedListener: OnViewPagerItemClickListener
) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentItemViewPager(list[position].imageId) {
            onItemClickedListener.onItemClick((position + 1).toString())
        }
    }

}