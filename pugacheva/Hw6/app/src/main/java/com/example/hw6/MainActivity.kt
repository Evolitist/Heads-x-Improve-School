package com.example.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var oneFragment: OneFragment
    private lateinit var twoFragment: TwoFragment
    private lateinit var threeFragment: ThreeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        homeItem()


        val botNav: BottomNavigationView = findViewById(R.id.btn_nav)
        botNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.item1 ->{
                    homeItem()
                }
            }
            when(item.itemId){
                R.id.item2 ->{
                    twoFragment = TwoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameL,twoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            when(item.itemId){
                R.id.item3 ->{
                    threeFragment = ThreeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameL,threeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
    private fun homeItem(){
        oneFragment = OneFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameL,oneFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

}