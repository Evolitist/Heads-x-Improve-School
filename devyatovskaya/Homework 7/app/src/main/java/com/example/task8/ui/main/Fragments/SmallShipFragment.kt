package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.task8.R
import com.example.task8.databinding.DetailFragmentBinding
import com.example.task8.ui.main.SpaceStyle
import com.example.task8.ui.main.ViewModels.ShipsViewModel
import com.example.task8.ui.main.adapter.SmallShipAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SmallShipFragment : Fragment() {

    private val viewModel by viewModels<ShipsViewModel>()
    private lateinit var binding: DetailFragmentBinding
    private lateinit var smallShipAdapter: SmallShipAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            list.apply{

                 lifecycleScope.launchWhenStarted {
                     viewModel.errors.collect {
                         Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
                     }
                 }

                smallShipAdapter = SmallShipAdapter {
                    findNavController().navigate(
                        SmallShipFragmentDirections.actionSmallShipFragmentToFullShipFragment(it)
                    )
                }
                binding.list.adapter = smallShipAdapter

                viewModel.starships.observe(viewLifecycleOwner) {
                    smallShipAdapter.submitList(it)
                }

                addItemDecoration(SpaceStyle())
            }

            viewModel.getStarships()
        }
    }
}