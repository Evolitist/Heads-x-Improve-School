package com.example.homework_3_2

import android.app.ActionBar
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.updateLayoutParams
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var CardVieww: CardView = findViewById(R.id.cv)

        var AppBarLayoutt: AppBarLayout = findViewById(R.id.appBarLayout)
        var Toolbarr: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        AppBarLayoutt.setOnClickListener {
            if (CardVieww.visibility == View.GONE) {
                CardVieww.visibility = View.VISIBLE
            } else {
                CardVieww.visibility = View.GONE
            }
        }
        Toolbarr.setOnClickListener {
            if (CardVieww.visibility == View.GONE) {
                CardVieww.visibility = View.VISIBLE
            } else {
                CardVieww.visibility = View.GONE
            }
        }

        setSupportActionBar(Toolbarr)
        AppBarLayoutt.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
            }
        })
    }


}