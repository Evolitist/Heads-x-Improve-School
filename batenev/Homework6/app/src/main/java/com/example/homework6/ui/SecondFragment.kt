package com.example.homework6.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.homework6.R
import com.example.homework6.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.second_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}