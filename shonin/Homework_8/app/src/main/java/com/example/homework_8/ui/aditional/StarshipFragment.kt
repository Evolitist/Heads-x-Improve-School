package com.example.homework_8.ui.aditional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_8.databinding.FragmentStarshipBinding
import com.example.homework_8.ui.model.Starship

class StarshipFragment : Fragment() {

    private lateinit var binding: FragmentStarshipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStarshipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: Starship? = arguments?.getParcelable<Starship>("arg")
        if (data != null) {
            binding.text1.text = "Name = " + data.name
            binding.text2.text = "Model = " + data.model
            binding.text3.text = "Starship class = " + data.starshipClass
            binding.text4.text = "Manufacturer = " + data.manufacturer
            binding.text5.text = "Cost in credits = " + data.costInCredits
            binding.text6.text = "Length = " + data.length
            binding.text7.text = "Crew = " + data.crew
            binding.text8.text = "Passengers = " + data.passengers
            binding.text9.text = "Max atmosphering speed = " + data.maxAtmospheringSpeed
            binding.text10.text = "Hyperdrive rating = " + data.hyperdriveRating
            binding.text11.text = "MGLT = " + data.MGLT
            binding.text12.text = "Cargo capacity = " + data.cargoCapacity
            binding.text13.text = "Consumables = " + data.consumables
            binding.text14.text = "Created = " + data.created
            binding.text15.text = "Edited = " + data.edited
        }
    }

}