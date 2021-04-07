package com.example.homework_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_6.databinding.FragmentFrag3Binding
import com.google.android.material.snackbar.Snackbar

class Frag3 : ViewBindingFragment(R.layout.fragment_frag3) {

    private val binding by viewBinding(FragmentFrag3Binding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView.setOnClickListener {
            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "Hello 3",
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }

}