package com.example.homework_8_retrofit_swapi.ui.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework_8_retrofit_swapi.databinding.FragmentInformationVehicleBinding

class FragmentInformationVehicle : Fragment() {

    private lateinit var binding: FragmentInformationVehicleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentInformationVehicleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataArgs: FragmentInformationVehicleArgs by navArgs()
        val informationVehicle = dataArgs.informationVehicles

        binding.textViewModelInformation.text = informationVehicle.model
        binding.textViewManufacturerInformation.text = informationVehicle.manufacturer
        binding.textViewCoastInformation.text = informationVehicle.costInCredits
        binding.textViewLengthInformation.text = informationVehicle.length
        binding.textViewCrewInformation.text = informationVehicle.crew
        binding.textViewPassengersInformation.text = informationVehicle.passengers
        binding.textViewCargoCapacityInformation.text = informationVehicle.cargoCapacity
        binding.textViewConsumablesInformation.text = informationVehicle.consumables
        binding.textViewVehiclesClassInformation.text = informationVehicle.vehicleClass

    }

}