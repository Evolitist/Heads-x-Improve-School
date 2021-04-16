package com.example.homework_8.ui.aditional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_8.databinding.FragmentPlanetBinding
import com.example.homework_8.ui.model.Planet

class PlanetFragment : Fragment() {

    private lateinit var binding: FragmentPlanetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: Planet? = arguments?.getParcelable<Planet>("arg")
        if (data != null) {
            binding.text1.text = "Name = " + data.name
            binding.text2.text = "Rotation period = " + data.rotationPeriod
            binding.text3.text = "Orbital period = " + data.orbitalPeriod
            binding.text4.text = "Diameter = " + data.diameter
            binding.text5.text = "Climate = " + data.climate
            binding.text6.text = "Gravity = " + data.gravity
            binding.text7.text = "Terrain = " + data.terrain
            binding.text8.text = "Surface water = " + data.surfaceWater
            binding.text9.text = "Population = " + data.population
            binding.text10.text = "Created = " + data.created
            binding.text11.text = "Edited = " + data.edited

        }
    }

}