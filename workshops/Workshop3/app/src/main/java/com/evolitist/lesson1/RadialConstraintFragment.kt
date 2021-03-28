package com.evolitist.lesson1

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.evolitist.lesson1.databinding.FragmentRadialConstraintBinding

class RadialConstraintFragment : ViewBindingFragment(R.layout.fragment_radial_constraint) {

    private val binding by viewBinding(FragmentRadialConstraintBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setupWithNavController(findNavController())

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_RadialConstraintFragment_to_itemFragment)
        }
    }
}