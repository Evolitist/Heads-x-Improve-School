package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.task8.databinding.FullFilmItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullFilmFragment : Fragment() {
    private val args by navArgs<FullFilmFragmentArgs>()
    private lateinit var binding: FullFilmItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FullFilmItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            title.text = args.film.title
            episodeId.text = args.film.episodeId.toString()
            director.text = args.film.director
            producer.text = args.film.producer
            created.text = args.film.created
            edited.text = args.film.edited
            openingCrawl.text = args.film.openingCrawl
        }
    }
}
