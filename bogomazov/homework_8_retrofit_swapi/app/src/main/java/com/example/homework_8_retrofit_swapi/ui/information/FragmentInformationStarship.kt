package com.example.homework_8_retrofit_swapi.ui.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework_8_retrofit_swapi.databinding.FragmentInformationStarshipBinding

class FragmentInformationStarship : Fragment() {

    private lateinit var binding: FragmentInformationStarshipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInformationStarshipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataNavArgs: FragmentInformationStarshipArgs by navArgs()
        val informationStarship = dataNavArgs.informationStarship

        binding.textViewModelInformation.text = informationStarship.model
        binding.textViewManufacturerInformation.text = informationStarship.manufacturer
        binding.textViewCoastInformation.text = informationStarship.costInCredits
        binding.textViewLengthInformation.text = informationStarship.length
        binding.textViewAtmospheringSpeedInformation.text = informationStarship.maxAtmosphereSpeed
        binding.textViewCrewInformation.text = informationStarship.crew
        binding.textViewPassengersInformation.text = informationStarship.passengers
        binding.textViewCargoCapacityInformation.text = informationStarship.cargoCapacity
        binding.textViewConsumablesInformation.text = informationStarship.consumables
        binding.textViewHyperDriveInformation.text = informationStarship.hyperdriveRating
        binding.textViewMGLTInformation.text = informationStarship.MGLT
        binding.textViewStarshipClassInformation.text = informationStarship.starshipClass
    }
}