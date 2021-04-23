package com.example.hw6.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hw6.R
import com.example.hw6.databinding.FragmentFourBinding
import com.example.hw6.ui.viewpager.OnViewPagerItemClickListener
import com.example.hw6.ui.viewpager.ViewPagerAdapter
import com.example.hw6.ui.viewpager.ViewPagerItem


class FragmentFour : Fragment() {

    private lateinit var binding: FragmentFourBinding
    private var listener: OnViewPagerItemClickListener? = null


    override fun onAttach(context: Context) {
        listener = requireActivity() as OnViewPagerItemClickListener
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPagerAdapter = ViewPagerAdapter(
            this,
            ViewPagerItem.getListImages(),
            listener!!
        )
        with(binding) {
            viewPager.adapter = viewPagerAdapter
            textViewPager.text = getString(R.string.textImage, 1)

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    textViewPager.text =
                        getString(R.string.textImage, position + 1)
                }
            })
            dots.setViewPager2(viewPager)

            closeBanner.setOnClickListener{
                findNavController().popBackStack()
            }
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }
}