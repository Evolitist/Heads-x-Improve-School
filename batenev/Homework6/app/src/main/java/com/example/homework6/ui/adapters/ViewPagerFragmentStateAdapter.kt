package com.example.homework6.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework6.ui.ItemPageFragment
import com.example.homework6.ui.common.OnViewPagerItemClickedListener
import data.ViewPagerItem

// Правильный нейминг взял выходной
class ViewPagerFragmentStateAdapter(
    fragment: Fragment,
    private val list: List<ViewPagerItem>,
    private val onItemClickedListener: OnViewPagerItemClickedListener
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ItemPageFragment(list[position].imageResId) {
            onItemClickedListener.onItemClicked((position + 1).toString())
        }
    }
}