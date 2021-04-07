package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar


class ViewPagerFragmentThree : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager_three, container, false)
        val img2: ImageView = view.findViewById(R.id.imageView3)
        img2.setOnClickListener {
            val snack = Snackbar.make(it,"Кросовок", Snackbar.LENGTH_LONG).show()
        }
        return view
    }


}