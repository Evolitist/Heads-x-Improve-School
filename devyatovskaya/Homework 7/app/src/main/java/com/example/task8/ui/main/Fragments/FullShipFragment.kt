package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.task8.databinding.FullShipItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullShipFragment : Fragment() {

    private val args by navArgs<FullShipFragmentArgs>()
    private lateinit var binding: FullShipItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FullShipItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            name.text = args.starship.name
            model.text = args.starship.model
            starShipClass.text = args.starship.starshipClass
            manufacturer.text = args.starship.manufacturer
            cost.text = args.starship.coastInCredits
            length.text = args.starship.length
            crew.text = args.starship.crew
            passengers.text = args.starship.passengers
            speed.text = args.starship.maxAtmospheringSpeed
            rating.text = args.starship.hyperdriveRating
            mglt.text = args.starship.MGLT
            capacity.text = args.starship.cargoCapacity
            consumables.text = args.starship.consumables
        }
    }
}