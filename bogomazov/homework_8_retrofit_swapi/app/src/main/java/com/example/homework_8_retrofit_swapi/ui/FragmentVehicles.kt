package com.example.homework_8_retrofit_swapi.ui

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_8_retrofit_swapi.R
import com.example.homework_8_retrofit_swapi.databinding.FragmentVehiclesBinding
import com.example.homework_8_retrofit_swapi.db.entities.DBModelVehicles
import com.example.homework_8_retrofit_swapi.model.ViewModelVehicles
import com.example.homework_8_retrofit_swapi.ui.adapter.AdapterRecyclerViewVehicles
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentVehicles : Fragment(), OnClickCardRecycler<DBModelVehicles> {

    private lateinit var binding: FragmentVehiclesBinding
    private lateinit var adapter: AdapterRecyclerViewVehicles
    private val model: ViewModelVehicles by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentVehiclesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        model.getVehicles()

        adapter = AdapterRecyclerViewVehicles(this)
        binding.recyclerViewVehicle.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewVehicle.adapter = adapter
        binding.recyclerViewVehicle.addItemDecoration(DecoratorItemRecyclerView(8,8,8,8))

        model.vehiclesDB.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.recyclerViewVehicle.isVisible = true
            binding.progressBar.isVisible = false
        }
    }

    override fun openNewFragment(dbModel: DBModelVehicles) {
        val action =
            FragmentVehiclesDirections.actionFragmentVehiclesToFragmentInformationVehicle(dbModel)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_database, menu)
        inflater.inflate(R.menu.menu_search_starship, menu)

        val search = menu.findItem(R.id.app_bar_search_starship)
        val searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                model.searchVehiclesInDB(query ?: "")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == "") {
                    model.getVehicles()
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_reload_db -> {
                binding.progressBar.isVisible = true
                binding.recyclerViewVehicle.isVisible = false
                model.getVehicles()
            }
            R.id.menu_item_remove_db -> {
                model.removeDbVehicles()
                adapter.submitList(null)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}