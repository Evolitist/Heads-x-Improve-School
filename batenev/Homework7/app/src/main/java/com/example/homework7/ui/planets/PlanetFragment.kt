package com.example.homework7.ui.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework7.databinding.FragmentItemInfoBinding
import com.example.homework7.ui.planets.list.PlanetsListFragment.Companion.PLANET_KEY
import com.example.homework7.ui.planets.model.PlanetUiModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class PlanetFragment : Fragment() {

    private lateinit var binding: FragmentItemInfoBinding
    private val viewModel: PlanetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planet = arguments?.getParcelable<PlanetUiModel>(PLANET_KEY)
        viewModel.setData(planet!!)
        viewModel.planet.observe(viewLifecycleOwner) {
            binding.tvItemInfo.text = it.toString()
        }
    }
}