package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.task8.databinding.DetailFragmentBinding
import com.example.task8.databinding.SmallPlanetItemBinding
import com.example.task8.network.planets.PlanetApiModel
import com.example.task8.ui.main.SpaceStyle
import com.example.task8.ui.main.ViewModels.PlanetViewModel
import com.example.task8.ui.main.adapter.AbstractAdapter
import com.example.task8.ui.main.adapter.PlanetViewHolder
import com.example.task8.ui.main.models.Planet
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SmallPlanetFragment : Fragment() {
    private val viewModel by viewModels<PlanetViewModel>()
    private lateinit var binding: DetailFragmentBinding
    private lateinit var smallPlanetAdapter: AbstractAdapter<Planet, PlanetViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            list.apply {

                lifecycleScope.launchWhenStarted {
                    viewModel.errors.collect {
                        println(it)
                        Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
                    }
                }
            }

            smallPlanetAdapter = AbstractAdapter(
                createViewHolder = { inflater, parent ->
                    PlanetViewHolder(SmallPlanetItemBinding.inflate(inflater, parent, false))
                },
                clickCallback = {
                    findNavController().navigate(
                        SmallPlanetFragmentDirections.actionSmallPlanetFragmentToFullPlanetFragment(it)
                    )
                }
            )

            list.adapter = smallPlanetAdapter

            viewModel.planets.observe(viewLifecycleOwner) {
                smallPlanetAdapter.submitList(it)
            }

            list.addItemDecoration(SpaceStyle())
        }

        viewModel.getPlanets()
    }
}