package com.example.homework4.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework4.R
import com.example.homework4.databinding.MybillsListFragmentBinding
import com.example.homework4.ui.adapters.MyBillsListAdapter
import com.example.homework4.ui.adapters.itemdecorations.MyBillsItemDecoration
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import data.Bill

class MyBillsListFragment : Fragment(R.layout.mybills_list_fragment) {

    private lateinit var binding: MybillsListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MybillsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            val layoutManager = GridLayoutManager(requireContext(), 2)
            layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (position) {
                        in 0..5 -> 1
                        else -> 2
                    }
                }
            }

            val adapter = MyBillsListAdapter()
            val itemDecoration = MyBillsItemDecoration()

            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(itemDecoration)
            adapter.submitList(Bill.getExampleList())

            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_info -> {
                        MaterialAlertDialogBuilder(requireContext())
                            .setTitle("Заголовок")
                            .setMessage("Текст")
                            .setNegativeButton(
                                "Закрыть",
                                DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() })
                            .create()
                            .show()
                        true
                    }
                    R.id.action_home -> {
                        Toast.makeText(
                            requireContext(),
                            "Home button has been clicked!",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    else -> super.onOptionsItemSelected(it)
                }
            }
        }
    }
}