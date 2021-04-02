package com.example.homework_5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_4.GridSpacingItemDecoration
import com.example.homework_5_2.databinding.ActivityMainBinding
import com.example.lesson_4.ItemAdapter
import com.example.lesson_4.PlaceholderItem
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        binding.list.addItemDecoration(GridSpacingItemDecoration(dpToPx(8)))


        adapter = ItemAdapter(
            this, arrayListOf(
                PlaceholderItem(UUID.randomUUID().toString(), "Услуги", null, null, null, 1),
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    "Предложить услугу",
                    null,
                    null,
                    ContextCompat.getDrawable(this, R.drawable.ic_partnership),
                    2
                ),
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    "Царь пышка",
                    "Скидка 10% на выпечку\n по коду",
                    "Лермонтовский пр, 52, МО №1",
                    ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                    3
                ),
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    "Химчистка \"МАЙ?\"",
                    "Скидка 5% на чистку пальто",
                    "Лермонтовский пр, 48",
                    ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                    3
                ),
                PlaceholderItem(
                    UUID.randomUUID().toString(),
                    "Шаурма У Ашота",
                    "При покупке шаурмы,\nфалафель бесплатно",
                    "Лермонтовский пр, 52, МО №1",
                    ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                    3
                )
            )
        )
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)
    }

    fun dpToPx(dp: Int): Int {
        val displayMetrics: DisplayMetrics = this.getResources().getDisplayMetrics()
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }
}