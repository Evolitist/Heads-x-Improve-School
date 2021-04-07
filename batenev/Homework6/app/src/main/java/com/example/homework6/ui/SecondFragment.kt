package com.example.homework6.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework6.R
import com.example.homework6.databinding.FragmentSecondBinding
import com.example.homework6.ui.adapters.StatisticsListAdapter
import com.example.homework6.ui.adapters.itemdecorations.StatisticsItemDecoration
import data.MeasurementData

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rvAdapter = StatisticsListAdapter()
        val dataList = MeasurementData.getSampleList()

        with(binding) {
            recyclerView.apply {
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(requireContext())
                rvAdapter.submitList(dataList)
                addItemDecoration(StatisticsItemDecoration())
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(
            requireContext(),
            "Toast",
            Toast.LENGTH_SHORT
        ).show()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.second_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}