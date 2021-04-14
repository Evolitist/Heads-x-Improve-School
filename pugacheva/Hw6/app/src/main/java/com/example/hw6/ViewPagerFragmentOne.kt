package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar


class ViewPagerFragmentOne : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager_one, container, false)
        val img1: ImageView = view.findViewById(R.id.imageView1)
        img1.setOnClickListener {
            val snack = Snackbar.make(it,"Шкаф", Snackbar.LENGTH_LONG).show()
        }
        return view
    }


}