package com.example.hw6

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView


class TwoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    var thiscontext: Context? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thiscontext = container?.getContext();
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        val btnLamp: ActionMenuItemView = view.findViewById(R.id.lamp)
        btnLamp.setOnClickListener {
            Toast.makeText(thiscontext, "Тык", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}