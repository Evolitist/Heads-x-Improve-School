package com.example.hw6.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hw6.R
import com.example.hw6.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_fragment_one, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_item -> {
                makeToast("Search item")
                true
            }
            R.id.itemOne -> {
                makeToast("Item One")
                true
            }
            R.id.itemTwo -> {
                makeToast("Item Two")
                true
            }
            R.id.itemThree -> {
                makeToast("Item Three")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun makeToast(item: String) {
        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
    }
}