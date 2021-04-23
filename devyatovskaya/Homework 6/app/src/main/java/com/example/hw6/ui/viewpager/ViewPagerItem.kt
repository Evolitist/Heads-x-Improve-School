package com.example.hw6.ui.viewpager

import com.example.hw6.R

data class ViewPagerItem(
    val imageId: Int
){
    companion object{
        fun getListImages() = listOf(
            ViewPagerItem(
                R.drawable.img_1
            ),
            ViewPagerItem(
                R.drawable.img_2
            ),
            ViewPagerItem(
                R.drawable.img_3
            )
        )
    }
}
