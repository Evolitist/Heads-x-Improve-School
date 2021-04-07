package com.example.homework6.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.homework6.databinding.ViewpagerItemBinding

class ItemPageFragment(
    private val imageResId: Int,
    private val onItemClick: () -> Unit
) : Fragment() {

    private lateinit var binding: ViewpagerItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewpagerItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.image.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                imageResId
            )
        )
        binding.image.setOnClickListener {
            onItemClick.invoke()
        }
    }

}