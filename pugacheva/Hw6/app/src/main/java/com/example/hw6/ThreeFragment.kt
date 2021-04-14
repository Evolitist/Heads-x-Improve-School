package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView


class ThreeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_three, container, false)
        var vis = 0
        val fr: FragmentContainerView = view.findViewById(R.id.fragment)
        val btn: Button = view.findViewById(R.id.button)
        btn.setOnClickListener {
            if (vis == 0){
                fr.visibility = VISIBLE
                btn.text = "Свернуть баннер"
                vis = 1
            }
            else {
                fr.visibility = INVISIBLE
                btn.text = "Показать баннер"
                vis = 0

            }
        }

        return view
    }

}
