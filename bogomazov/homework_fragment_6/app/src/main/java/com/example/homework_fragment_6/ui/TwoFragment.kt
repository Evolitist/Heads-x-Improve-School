package com.example.homework_fragment_6.ui

import android.os.Bundle
import android.text.Html
import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_fragment_6.AdapterListTile
import com.example.homework_fragment_6.R
import com.example.homework_fragment_6.data.DataListTile
import com.example.homework_fragment_6.databinding.FragmentTwoBinding
import java.util.*

class TwoFragment : Fragment() {
    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        val list = listOf(
                DataListTile(
                        "Холодная вода",
                        "Необходимо подать показания до 25.03.18",
                        "546563344",
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_water_cold)
                ),
                DataListTile(
                        "Горячая вода",
                        "Необходимо подать показания до 25.03.18",
                        "546563443",
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_water_hot)
                ),
                DataListTile(
                        title = "Электроэнергия",
                        textInfo = Html.fromHtml("Показания сданы <b>16.02.18</b> и будут учтены при следующем расчете <b>25.02.18</b>").toSpannable(),
                        id = "546562223",
                        image = ContextCompat.getDrawable(requireContext(), R.drawable.ic_electro_copy)
                )
        )

        val adapter = AdapterListTile()
        binding.recyclerViewFragmentTwo.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFragmentTwo.adapter = adapter
        adapter.submitList(list)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_two_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}