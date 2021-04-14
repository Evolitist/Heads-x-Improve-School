package com.example.homework_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_6.databinding.FragmentThirdBinding

class ThirdFragment : ViewBindingFragment(R.layout.fragment_first) {

    private val binding by viewBinding(FragmentThirdBinding::bind)

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        binding.viewpager.adapter = adapter

        binding.table.setupWithViewPager(binding.viewpager, true)

        binding.button.setOnClickListener {
            if (binding.viewpager.visibility == View.VISIBLE) {
                binding.button.text = "Показать баннер"
                binding.viewpager.visibility = View.GONE
                binding.table.visibility = View.GONE
            } else {
                binding.button.text = "Свернуть баннер"
                binding.viewpager.visibility = View.VISIBLE
                binding.table.visibility = View.VISIBLE
            }
        }
    }

}