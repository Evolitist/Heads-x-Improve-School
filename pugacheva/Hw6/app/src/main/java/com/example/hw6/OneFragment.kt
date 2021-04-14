package com.example.hw6

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment


class OneFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    var thiscontext: Context? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_one, container, false)
        thiscontext = container?.getContext();

        val btnMenu: ActionMenuItemView = view.findViewById(R.id.menu_fr1)

        btnMenu.setOnClickListener {
            showPopup(btnMenu)
        }

        val btnSearch: ActionMenuItemView = view.findViewById(R.id.search)
        btnSearch.setOnClickListener {
            Toast.makeText(thiscontext, "Что-то ищите?", Toast.LENGTH_SHORT).show()
        }



        return view
    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(thiscontext, view)
        popup.inflate(R.menu.popupmenu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.header1 -> {
                    Toast.makeText(thiscontext, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.header2 -> {
                    Toast.makeText(thiscontext, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.header3 -> {
                    Toast.makeText(thiscontext, item.title, Toast.LENGTH_SHORT).show()
                }
            }

            true
        })

        popup.show()

    }


}