package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar


class ViewPagerFragmentTwo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager_two, container, false)
        val img3: ImageView = view.findViewById(R.id.imageView2)
        img3.setOnClickListener {
            val snack = Snackbar.make(it,"Проигрыватель и скейт", Snackbar.LENGTH_LONG).show()
        }
        return view
    }

}