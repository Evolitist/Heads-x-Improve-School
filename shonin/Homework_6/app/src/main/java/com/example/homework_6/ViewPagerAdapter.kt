package com.example.homework_6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = Frag1()
            1 -> fragment = Frag2()
            2 -> fragment = Frag3()
        }

        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }
}
