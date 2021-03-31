package com.example.homework_4

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.DisplayMetrics
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_4.databinding.ActivityMainBinding
import com.example.lesson_4.ItemAdapter
import com.example.lesson_4.PlaceholderItem
import java.util.*

class MainActivity : AppCompatActivity(){

    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.list.addItemDecoration(GridSpacingItemDecoration( dpToPx(8)))


        adapter = ItemAdapter(this , arrayListOf(
            PlaceholderItem(UUID.randomUUID().toString(),"Квитанции", "- 40 080,55 " + Html.fromHtml(" &#x20bd"), ContextCompat.getDrawable(this,R.drawable.ic_bill), ContextCompat.getColor(this,R.color.red), 2),
            PlaceholderItem(UUID.randomUUID().toString(),"Счетчики", "Подайте показания", ContextCompat.getDrawable(this,R.drawable.ic_counter), ContextCompat.getColor(this,R.color.red), 2),
            PlaceholderItem(UUID.randomUUID().toString(),"Рассрочка", "Сл. платеж 25.02.2018", ContextCompat.getDrawable(this,R.drawable.ic_installment), null, 2),
            PlaceholderItem(UUID.randomUUID().toString(),"Страхование", "Полис до 12.01.2019", ContextCompat.getDrawable(this,R.drawable.ic_insurance), null, 2),
            PlaceholderItem(UUID.randomUUID().toString(),"Интернет и ТВ", "Баланс 350 " + Html.fromHtml(" &#x20bd"), ContextCompat.getDrawable(this,R.drawable.ic_tv), null, 2),
            PlaceholderItem(UUID.randomUUID().toString(),"Домофон", "Подключен", ContextCompat.getDrawable(this,R.drawable.ic_homephone), null, 2),
            PlaceholderItem(UUID.randomUUID().toString(),"Охрана", "Нет", ContextCompat.getDrawable(this,R.drawable.ic_guard), null, 1),
            PlaceholderItem(UUID.randomUUID().toString(),"Контакты УК и служб", null, ContextCompat.getDrawable(this,R.drawable.ic_uk_contacts), null, 1),
            PlaceholderItem(UUID.randomUUID().toString(),"Мои заявки", null, ContextCompat.getDrawable(this,R.drawable.ic_request), null, 1),
            PlaceholderItem(UUID.randomUUID().toString(),"Памятка жителя А101", null, ContextCompat.getDrawable(this,R.drawable.ic_about), null, 1)
        ))
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this,2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int) = when (position > 5) {
                    true -> 2
                    else -> 1
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ic_1 -> {
                Toast.makeText(this, "This is toast!", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.ic_2 -> {
                basicAlert()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun basicAlert(){

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Сделал Дмитрий")
            setMessage("Одобрил Олег")
            setPositiveButton("OK") {
                    dialog, id ->  dialog.cancel()
            }
        }
        val alertDialog = builder.create()
        alertDialog.show()

        val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
        with(button) {
            setTextColor(Color.BLACK)
        }
    }

    fun dpToPx(dp: Int): Int {
        val displayMetrics: DisplayMetrics = this.getResources().getDisplayMetrics()
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }
}

