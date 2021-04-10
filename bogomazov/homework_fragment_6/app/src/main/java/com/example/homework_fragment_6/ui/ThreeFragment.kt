package com.example.homework_fragment_6.ui

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.homework_fragment_6.R
import com.example.homework_fragment_6.ViewPagerAdapter
import com.example.homework_fragment_6.databinding.FragmentThreeBinding

class ThreeFragment : Fragment(){

    private lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = listOf<Drawable?>(
                ContextCompat.getDrawable(requireContext(), R.drawable.img_1),
                ContextCompat.getDrawable(requireContext(), R.drawable.img_2),
                ContextCompat.getDrawable(requireContext(), R.drawable.img_3)
        )

        val adapter = ViewPagerAdapter(list)
        binding.viewPagerFragmentThree.adapter = adapter

        setTitleSelectedImage(position = 1)

        var doppelgangerPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setDefaultColorPoint()
                changeSelectedIcon(position)
                setTitleSelectedImage(position+1)
            }
        }

        binding.viewPagerFragmentThree.registerOnPageChangeCallback(doppelgangerPageChangeCallback)

        binding.buttonShowFragmentThree.setOnClickListener {
            binding.viewPagerFragmentThree.isVisible = !binding.viewPagerFragmentThree.isVisible
            binding.groupImagePagerSelected.isVisible = !binding.groupImagePagerSelected.isVisible
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun changeSelectedIcon(position: Int) {
        when(position){
            0 -> changeColorSelectedIcon(binding.selectionIconFirst)
            1 -> changeColorSelectedIcon(binding.selectionIconTwo)
            2 -> changeColorSelectedIcon(binding.selectionIconThree)
        }
    }

    private fun setTitleSelectedImage(position: Int){
        binding.textViewSelectedImage.text = "Картинка $position"
    }

    private fun setDefaultColorPoint() {
        binding.selectionIconFirst.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(),R.color.default_color_point))
        binding.selectionIconTwo.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(),R.color.default_color_point))
        binding.selectionIconThree.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(),R.color.default_color_point))
    }

    private fun changeColorSelectedIcon(point: ImageView){
        point.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(),R.color.active_color_point))
    }

}
