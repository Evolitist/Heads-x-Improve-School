package com.example.homework_8_retrofit_swapi.ui.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework_8_retrofit_swapi.databinding.FragmentInformationPlanetBinding

class FragmentInformationPlanet : Fragment() {

    private lateinit var binding: FragmentInformationPlanetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInformationPlanetBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataNavArgs: FragmentInformationPlanetArgs by navArgs()
        val dataPlanet = dataNavArgs.informationPlanet

        binding.textViewNamePlanetInformation.text = dataPlanet.name
        binding.textViewRotationPeriodInformation.text = dataPlanet.rotationPeriod
        binding.textViewOrbitalPeriodInformation.text = dataPlanet.orbitalPeriod
        binding.textViewDiametrInformation.text = dataPlanet.diameter
        binding.textViewClimateInformation.text = dataPlanet.climate
        binding.textViewGravityInformation.text = dataPlanet.gravity
        binding.textViewTerrainInformation.text = dataPlanet.terrain
        binding.textViewSurfaceWaterInformation.text = dataPlanet.surfaceWater
        binding.textViewPopulationInformation.text = dataPlanet.population
    }

}