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
import com.example.task8.databinding.SmallShipItemBinding
import com.example.task8.ui.main.SpaceStyle
import com.example.task8.ui.main.ViewModels.ShipsViewModel
import com.example.task8.ui.main.adapter.AbstractAdapter
import com.example.task8.ui.main.adapter.ShipViewHolder
import com.example.task8.ui.main.models.Starship
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SmallShipFragment : Fragment() {

    private val viewModel by viewModels<ShipsViewModel>()
    private lateinit var binding: DetailFragmentBinding
    private lateinit var smallShipAdapter: AbstractAdapter<Starship, ShipViewHolder>

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
                        Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
                    }
                }
            }

            smallShipAdapter = AbstractAdapter(
                createViewHolder = { inflater, parent ->
                    ShipViewHolder(SmallShipItemBinding.inflate(inflater, parent, false))
                },
                clickCallback = {
                    findNavController().navigate(
                        SmallShipFragmentDirections.actionSmallShipFragmentToFullShipFragment(it)
                    )
                }
            )

            list.adapter = smallShipAdapter

            viewModel.starships.observe(viewLifecycleOwner) {
                smallShipAdapter.submitList(it)
            }

            list.addItemDecoration(SpaceStyle())
        }

        viewModel.getStarships()
    }
}