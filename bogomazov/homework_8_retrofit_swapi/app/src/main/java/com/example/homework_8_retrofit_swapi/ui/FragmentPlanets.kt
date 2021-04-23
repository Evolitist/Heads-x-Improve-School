package com.example.homework_8_retrofit_swapi.ui

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_8_retrofit_swapi.R
import com.example.homework_8_retrofit_swapi.databinding.FragmentPlanetsBinding
import com.example.homework_8_retrofit_swapi.db.entities.DBModelPlanets
import com.example.homework_8_retrofit_swapi.model.ViewModelPlanet
import com.example.homework_8_retrofit_swapi.ui.adapter.AdapterRecyclerViewPlanets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentPlanets : Fragment(), OnClickCardRecycler<DBModelPlanets> {

    private lateinit var adapter: AdapterRecyclerViewPlanets
    private lateinit var binding: FragmentPlanetsBinding
    private val model: ViewModelPlanet by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanetsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        model.getPlanet()

        adapter = AdapterRecyclerViewPlanets(this)
        binding.recyclerViewPlanets.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPlanets.adapter = adapter
        binding.recyclerViewPlanets.addItemDecoration(DecoratorItemRecyclerView(8,8,8,8))

        model.planetDB.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.recyclerViewPlanets.isVisible = true
            binding.progressBar.isVisible = false
        }
    }

    override fun openNewFragment(dbModel: DBModelPlanets) {
        val action =
            FragmentPlanetsDirections.actionFragmentPlanetsToFragmentInformationPlanet(dbModel)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_database, menu)
        inflater.inflate(R.menu.menu_search_starship, menu)

        val search = menu.findItem(R.id.app_bar_search_starship)
        val searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                model.searchPlanetInDB(query ?: "")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == "") {
                    model.getPlanet()
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
                binding.recyclerViewPlanets.isVisible = false
                model.getPlanet()
            }
            R.id.menu_item_remove_db -> {
                model.removeAllPlanet()
                adapter.submitList(null)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}