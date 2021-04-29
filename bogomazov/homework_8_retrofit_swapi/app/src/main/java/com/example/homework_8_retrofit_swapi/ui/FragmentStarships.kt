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
import com.example.homework_8_retrofit_swapi.databinding.FragmentStarshipsBinding
import com.example.homework_8_retrofit_swapi.db.entities.DBModelStarship
import com.example.homework_8_retrofit_swapi.model.ViewModelStarship
import com.example.homework_8_retrofit_swapi.ui.adapter.AdapterRecyclerViewStarship
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentStarships : Fragment(), OnClickCardRecycler<DBModelStarship> {

    private val model: ViewModelStarship by viewModels()
    private lateinit var binding: FragmentStarshipsBinding
    private lateinit var adapter: AdapterRecyclerViewStarship

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStarshipsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        model.getStarship()

        adapter = AdapterRecyclerViewStarship(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DecoratorItemRecyclerView(8,8,8,8))

        model.starshipsDB.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.progressBar.isVisible = false
            binding.recyclerView.isVisible = true
        }
    }

    override fun openNewFragment(dbModel: DBModelStarship) {
        val action =
            FragmentStarshipsDirections.actionMainFragmentToFragmentInformationStarship(dbModel)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_starship, menu)
        inflater.inflate(R.menu.menu_toolbar_database, menu)

        val search = menu.findItem(R.id.app_bar_search_starship)
        val searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                model.searchStarshipInDB(query ?: "")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == "") {
                    model.getStarship()
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_remove_db -> {
                model.removeDbStarship()
                adapter.submitList(null)
            }
            R.id.menu_item_reload_db -> {
                binding.progressBar.isVisible = true
                binding.recyclerView.isVisible = false
                model.getStarship()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}


