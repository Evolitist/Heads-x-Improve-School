package com.evolitist.lesson1

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.evolitist.lesson1.databinding.FragmentSecondBinding

class SecondFragment : ViewBindingFragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ChainTypesFragment)
        }
    }
}