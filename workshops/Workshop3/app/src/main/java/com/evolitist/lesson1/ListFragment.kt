package com.evolitist.lesson1

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.evolitist.lesson1.databinding.FragmentListBinding
import com.evolitist.lesson1.placeholder.PlaceholderContent

class ListFragment : ViewBindingFragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)
    private lateinit var adapter: ItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.layoutManager = GridLayoutManager(requireContext(), 3).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int) = when (position % 5) {
                    0, 3 -> 1
                    1, 2 -> 2
                    else -> 3
                }
            }
        }
        adapter = ItemAdapter()
        binding.list.adapter = adapter

        adapter.submitList(PlaceholderContent.ITEMS)
    }
}
