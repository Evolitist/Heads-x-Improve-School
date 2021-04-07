package data

import com.example.homework6.R

data class ViewPagerItem(
    val imageResId: Int
) {
    companion object {
        fun getSampleList() = listOf(
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