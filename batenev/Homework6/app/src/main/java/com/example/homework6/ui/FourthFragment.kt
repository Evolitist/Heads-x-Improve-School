package com.example.homework6.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework6.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }
}