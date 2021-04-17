package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.task8.databinding.DetailFragmentBinding
import com.example.task8.databinding.SmallFilmItemBinding
import com.example.task8.network.films.FilmApiModel
import com.example.task8.ui.main.SpaceStyle
import com.example.task8.ui.main.ViewModels.FilmsViewModel
import com.example.task8.ui.main.adapter.AbstractAdapter
import com.example.task8.ui.main.adapter.FilmViewHolder
import com.example.task8.ui.main.models.Film
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SmallFilmFragment : Fragment() {

    private val viewModel by viewModels<FilmsViewModel>()
    private lateinit var binding: DetailFragmentBinding
    private lateinit var smallFilmsAdapter: AbstractAdapter<Film, FilmViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            list.apply {

                lifecycleScope.launchWhenCreated {
                    viewModel.errors.collect {
                        Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
                    }
                }
            }

            smallFilmsAdapter = AbstractAdapter(
                createViewHolder = { inflater, parent ->
                    FilmViewHolder(SmallFilmItemBinding.inflate(inflater, parent, false))
                },
                clickCallback = {
                    findNavController().navigate(
                        SmallFilmFragmentDirections.actionSmallFilmFragmentToFullFilmFragment(it)
                    )
                }
            )
            binding.list.adapter = smallFilmsAdapter

            viewModel.films.observe(viewLifecycleOwner) {
                smallFilmsAdapter.submitList(it)
            }

            list.addItemDecoration(SpaceStyle())
        }
        viewModel.getFilms()
    }
}

