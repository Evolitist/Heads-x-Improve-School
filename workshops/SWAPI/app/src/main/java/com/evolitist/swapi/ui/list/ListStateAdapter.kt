package com.evolitist.swapi.ui.list

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolitist.swapi.databinding.ListLoaderBinding
import com.evolitist.swapi.ui.inflater

class ListStateAdapter(
    private val retry: () -> Unit,
) : LoadStateAdapter<ListStateAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = ViewHolder(
        ListLoaderBinding.inflate(parent.inflater, parent, false),
        retry,
    )

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class ViewHolder(
        private val binding: ListLoaderBinding,
        retry: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryButton.setOnClickListener { retry() }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.errorMessage.text = loadState.error.localizedMessage
            }
            binding.spinner.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState !is LoadState.Loading
            binding.errorMessage.isVisible = loadState !is LoadState.Loading
        }
    }
}
