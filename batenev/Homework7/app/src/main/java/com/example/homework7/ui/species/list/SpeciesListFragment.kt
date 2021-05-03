package com.example.homework7.ui.species.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.R
import com.example.homework7.databinding.FragmentSpeciesBinding
import com.example.homework7.ext.showSnackBar
import com.example.homework7.ui.common.FetchViewState
import com.example.homework7.ui.species.model.SpeciesUiModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpeciesListFragment : Fragment() {

    private val viewModel: SpeciesListViewModel by viewModels()
    private var _binding: FragmentSpeciesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpeciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = SpeciesListAdapter {
            findNavController().navigate(
                R.id.action_navigation_species_to_speciesFragment,
                bundleArgs(it)
            )
        }
        binding.recyclerView.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            )
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == recyclerView.adapter!!.itemCount - 1) {
                        viewModel.getNextPage()
                    }
                }
            })
        }

        viewModel.species.observe(viewLifecycleOwner) {
            when (it) {
                is FetchViewState.Loading -> {
                    binding.root.showSnackBar(getString(R.string.common_loading_string))
                }
                is FetchViewState.Data -> rvAdapter.submitList(it.data)
                is FetchViewState.ApiError -> {
                    binding.root.showSnackBar(getString(R.string.common_apiError_string))
                }
                FetchViewState.Empty -> {
                    binding.root.showSnackBar(getString(R.string.common_emptyResponse_string))
                }
                FetchViewState.NetworkError -> {
                    binding.root.showSnackBar(getString(R.string.common_networkError_string))
                }
                FetchViewState.UnknownError -> {
                    binding.root.showSnackBar(getString(R.string.common_unknownError_string))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val SPECIES_KEY = "SpeciesKey"
        private fun bundleArgs(item: SpeciesUiModel) = bundleOf(
            SPECIES_KEY to item
        )
    }
}