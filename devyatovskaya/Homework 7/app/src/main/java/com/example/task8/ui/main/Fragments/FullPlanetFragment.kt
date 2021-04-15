package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.task8.databinding.FullPlanetItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullPlanetFragment : Fragment() {
    private val args by navArgs<FullPlanetFragmentArgs>()
    private lateinit var binding: FullPlanetItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FullPlanetItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            name.text = args.planet.name
            diameter.text = args.planet.diameter
            rotation.text = args.planet.rotationPeriod
            orbital.text = args.planet.orbitalPeriod
            gravity.text = args.planet.gravity
            population.text = args.planet.population
            climate.text = args.planet.climate
            terrain.text = args.planet.terrain
            water.text = args.planet.surfaceWater
            created.text = args.planet.created
            edited.text = args.planet.edited
        }
    }
}
