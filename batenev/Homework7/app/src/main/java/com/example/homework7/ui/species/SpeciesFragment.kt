package com.example.homework7.ui.species

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework7.databinding.FragmentItemInfoBinding
import com.example.homework7.ui.species.list.SpeciesListFragment.Companion.SPECIES_KEY
import com.example.homework7.ui.species.model.SpeciesUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpeciesFragment : Fragment() {

    private lateinit var binding: FragmentItemInfoBinding
    private val viewModel: SpeciesViewModel by viewModels()

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
        val specie = arguments?.getParcelable<SpeciesUiModel>(SPECIES_KEY)
        viewModel.setData(specie!!)
        viewModel.species.observe(viewLifecycleOwner) {
            binding.tvItemInfo.text = it.toString()
        }
    }
}