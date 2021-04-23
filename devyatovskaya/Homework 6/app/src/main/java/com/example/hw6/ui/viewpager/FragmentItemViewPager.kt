package com.example.hw6.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.hw6.databinding.ViewpagerItemBinding

class FragmentItemViewPager(
    private val imageId: Int,
    private val onItemClick: () -> Unit
): Fragment() {

    private lateinit var binding: ViewpagerItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewpagerItemBinding.inflate(LayoutInflater.from(context), container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageViewpager.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                imageId
            )
        )
        binding.imageViewpager.setOnClickListener{
            onItemClick.invoke()
        }
    }
}