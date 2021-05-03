package com.example.homework7.ui.planets.list

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
import com.example.homework7.databinding.FragmentPlanetsBinding
import com.example.homework7.ext.showSnackBar
import com.example.homework7.ui.common.FetchViewState
import com.example.homework7.ui.planets.model.PlanetUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetsListFragment : Fragment() {

    private val viewModel: PlanetsListViewModel by viewModels()
    private var _binding: FragmentPlanetsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter = PlanetsListAdapter {
            findNavController().navigate(
                R.id.action_navigation_planets_to_planetFragment,
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

        viewModel.planets.observe(viewLifecycleOwner) {
            when (it) {
                is FetchViewState.Loading -> {
                    binding.root.showSnackBar(getString(R.string.common_loading_string))
                }
                is FetchViewState.Data<List<PlanetUiModel>> -> rvAdapter.submitList(it.dataValue())
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
        const val PLANET_KEY = "PlanetKey"
        private fun bundleArgs(item: PlanetUiModel) = bundleOf(
            PLANET_KEY to item
        )
    }
}