package com.example.homework_5_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ConcatAdapter
import com.example.homework_5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val list = listOf<ListTileData>(
                ListTileData("Скидка 10% на выпечку \nпо коду", "Царь пышка", "Лермонтовский пр, 52, МО №1", ContextCompat.getDrawable(this, R.drawable.alya_parizh)),
                ListTileData("Скидка 5% на чистку пальто", "Химчистка «МАЙ?»", "Лермонтовский пр, 48", ContextCompat.getDrawable(this, R.drawable.mai)),
                ListTileData("При покупке шавермы, \nфалафель бесплатно", "Шаверма У Ашота ", "Лермонтовский пр, 52, МО №1", ContextCompat.getDrawable(this, R.drawable.ashot))
        )

        val adapterHeaderTile = AdapterHeader()
        val adapterTileList = AdapterListTile()

        val concatAdapter = ConcatAdapter(adapterHeaderTile, adapterTileList)

        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = concatAdapter
        binding.recView.addItemDecoration(ItemDecorationCustomMargins(8, 20, 8, 20))

        adapterTileList.submitList(list)
    }
}