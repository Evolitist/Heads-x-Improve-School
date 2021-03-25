package com.evolitist.lesson1

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.evolitist.lesson1.databinding.FragmentChainTypesBinding

class ChainTypesFragment : ViewBindingFragment(R.layout.fragment_chain_types) {

    private val binding by viewBinding(FragmentChainTypesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setupWithNavController(findNavController())

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_ChainTypesFragment_to_RadialConstraintFragment)
        }
    }
}