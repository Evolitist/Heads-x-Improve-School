package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.task8.databinding.DetailFragmentBinding
import com.example.task8.ui.main.SpaceStyle
import com.example.task8.ui.main.ViewModels.FilmsViewModel
import com.example.task8.ui.main.adapter.SmallFilmsAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SmallFilmFragment : Fragment() {

    private val viewModel by viewModels<FilmsViewModel>()
    private lateinit var binding: DetailFragmentBinding
    private lateinit var smallFilmsAdapter: SmallFilmsAdapter

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

                smallFilmsAdapter = SmallFilmsAdapter {
                    findNavController().navigate(
                        SmallFilmFragmentDirections.actionSmallFilmFragmentToFullFilmFragment(it)
                    )
                }
                binding.list.adapter = smallFilmsAdapter

                viewModel.films.observe(viewLifecycleOwner) {
                    smallFilmsAdapter.submitList(it)
                }

                addItemDecoration(SpaceStyle())

                viewModel.getFilms()

            }
        }
    }
}
