package com.example.homework_6

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_6.databinding.FragmentSecondBinding
import java.util.*

class SecondFragment : ViewBindingFragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)

    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.addItemDecoration(GridSpacingItemDecoration(dpToPx(8)))

        adapter = ItemAdapter(
            requireContext(), arrayListOf(
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    54656553,
                    "Холодная вода",
                    "Новые показания",
                    null,
                    null,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_water_cold),
                    "Необходимо подать показания до 25.03.18",
                    1
                ),
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    54656553,
                    "Горячая вода",
                    "Новые показания",
                    null,
                    null,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_water_hot),
                    "Необходимо подать показания до 25.03.18",
                    1
                ),
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    54656553,
                    "Электроэнергия",
                    "День",
                    "Ночь",
                    "Пик",
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_electro_copy),
                    "Показания сданы 16.02.18 и будут учтены при\nследующем расчете 25.03.18",
                    null
                )
            )
        )
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_second, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.lamp -> {
                Toast.makeText(requireContext(), "This is toast!", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun dpToPx(dp: Int): Int {
        val displayMetrics: DisplayMetrics = this.getResources().getDisplayMetrics()
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

}