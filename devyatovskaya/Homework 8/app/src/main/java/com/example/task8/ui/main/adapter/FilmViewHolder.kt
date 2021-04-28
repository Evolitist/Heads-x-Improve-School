package com.example.task8.ui.main.adapter

import com.example.task8.databinding.SmallFilmItemBinding
import com.example.task8.ui.main.models.Film

class FilmViewHolder(
    private val binding: SmallFilmItemBinding
) : AbstractAdapter.ViewHolder<Film>(binding) {

    override fun bind(data: Film, onClick: (Film) -> Unit) {
        binding.title.text = data.title
        binding.episode.text = data.episodeId.toString()
        binding.root.setOnClickListener {
            onClick(data)
        }
    }
}