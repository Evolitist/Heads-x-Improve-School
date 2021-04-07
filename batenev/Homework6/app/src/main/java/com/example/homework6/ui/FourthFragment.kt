package com.example.homework6.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.homework6.R
import com.example.homework6.databinding.FragmentFourthBinding
import com.example.homework6.ui.adapters.ViewPagerFragmentStateAdapter
import com.example.homework6.ui.common.OnViewPagerItemClickedListener
import data.ViewPagerItem

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding
    private var listener: OnViewPagerItemClickedListener? = null

    override fun onAttach(context: Context) {
        listener = requireActivity() as OnViewPagerItemClickedListener
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val vpAdapter = ViewPagerFragmentStateAdapter(
            this,
            ViewPagerItem.getSampleList(),
            listener!!
        )
        with(binding) {
            viewPager.adapter = vpAdapter
            //Стартовое значение для строки под вьюпейджером
            tvPagerPosition.text =
                getString(R.string.fragmentFourth_pagerPosition_text, 1)

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tvPagerPosition.text =
                        getString(R.string.fragmentFourth_pagerPosition_text, position + 1)
                }
            })
            dots.setViewPager2(viewPager)

            btnCloseBanner.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

}