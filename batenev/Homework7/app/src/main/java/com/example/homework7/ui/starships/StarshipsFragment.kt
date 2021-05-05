package com.example.homework7.ui.starships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework7.databinding.FragmentItemInfoBinding
import com.example.homework7.ui.starships.list.StarshipsListFragment.Companion.STARSHIP_KEY
import com.example.homework7.ui.starships.model.StarshipUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipsFragment : Fragment() {

    private lateinit var binding: FragmentItemInfoBinding
    private val viewModel: StarshipsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val starship = arguments?.getParcelable<StarshipUiModel>(STARSHIP_KEY)
        viewModel.setData(starship!!)
        viewModel.starship.observe(viewLifecycleOwner) {
            binding.tvItemInfo.text = it.toString()
        }
    }
}