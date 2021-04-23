package com.example.hw6.ui.fragments

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.*
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import com.example.hw6.GridSpace
import com.example.hw6.R
import com.example.hw6.databinding.FragmentSecondBinding
import com.example.hw6.ui.fragments.adapter.AdapterFragmentTwo
import com.example.hw6.ui.fragments.adapter.AdapterFragmentTwo.Companion.VIEW_ONE
import com.example.hw6.ui.fragments.adapter.AdapterFragmentTwo.Companion.VIEW_TWO
import com.example.hw6.ui.fragments.adapter.PlaceholderItem

class FragmentSecond : Fragment() {

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
        super.onViewCreated(view, savedInstanceState)

        val fragAdapter = AdapterFragmentTwo()
        val electroString = SpannableStringBuilder()
            .append("Показания сданы ")
            .bold { append("16.02.18 ") }
            .append("и будут учтены при следующем расчете ")
            .bold { append("25.02.18 ") }

        val waterString = SpannableStringBuilder()
            .append("Необходимо подать показания до 25.03.18")

        val dataList = listOf(
            PlaceholderItem(
                "Холодная вода",
                ResourcesCompat.getDrawable(resources, R.drawable.ic_water_cold, null),
                waterString,
                VIEW_ONE
            ),
            PlaceholderItem(
                "Горячая вода",
                ResourcesCompat.getDrawable(resources, R.drawable.ic_water_hot, null),
                waterString,
                VIEW_ONE
            ),
            PlaceholderItem(
                "Электроэнергия",
                ResourcesCompat.getDrawable(resources, R.drawable.ic_electro_copy, null),
                electroString,
                VIEW_TWO
            )
        )

        with(binding) {
            list.apply {
                adapter = fragAdapter
                fragAdapter.submitList(dataList)
                addItemDecoration(GridSpace())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_item_two, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.light -> {
                makeToast("Lamp")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun makeToast(item: String) {
        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
    }
}