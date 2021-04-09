package com.evolitist.swapi.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.evolitist.swapi.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel by viewModels<ListViewModel>()
    private lateinit var binding: ListFragmentBinding
    private lateinit var itemAdapter: ListItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter = ListItemAdapter {
            findNavController().navigate(
                ListFragmentDirections.actionListFragmentToDetailFragment(it)
            )
        }
        itemAdapter.addLoadStateListener {
            val isRefreshing = it.refresh is LoadState.Loading
            if (!isRefreshing) {
                binding.swipeRefreshLayout.isRefreshing = false
            }
            binding.progress.isVisible = isRefreshing
            binding.list.isVisible = it.refresh is LoadState.NotLoading
        }

        binding.list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter.withLoadStateFooter(ListStateAdapter(itemAdapter::retry))
            addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            )
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            itemAdapter.refresh()
        }

        lifecycleScope.launch {
            viewModel.peopleList.collectLatest {
                itemAdapter.submitData(it)
            }
        }
    }
}
