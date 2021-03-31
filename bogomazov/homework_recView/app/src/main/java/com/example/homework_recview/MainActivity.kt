package com.example.homework_recview

import android.app.Dialog
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_recview.databinding.ActivityMainBinding
import android.content.Context
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.homework_recview.data.DataClassGrid
import com.example.homework_recview.data.DataClassLinear
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

private lateinit var binding: ActivityMainBinding
private lateinit var adapterGrid: GridRecAdapter
private lateinit var adapterLiner: LinearRecAdapter

class MainActivity : AppCompatActivity(), OnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val dataClassGrid = mutableListOf<DataClassGrid>(
                DataClassGrid("Квитанции", "- 40 080,55 ₽ ", ContextCompat.getDrawable(this, R.drawable.ic_bill), true),
                DataClassGrid("Счетчики", "Подайте показания", ContextCompat.getDrawable(this, R.drawable.ic_counter), true),
                DataClassGrid("Рассрочка", "Сл. платеж 25.02.2018", ContextCompat.getDrawable(this, R.drawable.ic_installment)),
                DataClassGrid("Страхование ", "Полис до 12.01.2019", ContextCompat.getDrawable(this, R.drawable.ic_insurance)),
                DataClassGrid("Интернет и ТВ", "Баланс 350 ₽", ContextCompat.getDrawable(this, R.drawable.ic_tv)),
                DataClassGrid("Домофон", "Подключен", ContextCompat.getDrawable(this, R.drawable.ic_homephone)),
                DataClassGrid("Охрана", "Нет", ContextCompat.getDrawable(this, R.drawable.ic_guard))
        )

        val dataClassLinear = mutableListOf<DataClassLinear>(
                DataClassLinear("Контакты УК и служб", ContextCompat.getDrawable(this, R.drawable.ic_uk_contacts)),
                DataClassLinear("Мои заявки", ContextCompat.getDrawable(this, R.drawable.ic_request)),
                DataClassLinear("Памятка жителя А101", ContextCompat.getDrawable(this, R.drawable.ic_about))
        )

        var dataClassGridSize = if (dataClassGrid.size % 2 == 0) dataClassGrid.size else dataClassGrid.size - 1

        adapterGrid = GridRecAdapter(dataClassGridSize, this)
        adapterLiner = LinearRecAdapter(this)

        val concatAdapter = ConcatAdapter(adapterGrid, adapterLiner)

        binding.recViewLayout.layoutManager = GridLayoutManager(this, 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int) = when (position) {
                    in 0 until dataClassGridSize -> 1
                    else -> 2
                }
            }
        }

        binding.recViewLayout.adapter = concatAdapter
        binding.recViewLayout.addItemDecoration(ItemDecorationCustomMargins(4, 4, 4, 4))
        adapterGrid.submitList(dataClassGrid)
        adapterLiner.submitList(dataClassLinear)

        binding.buttonHome.setOnClickListener {
            Toast.makeText(this, "Version 1.1.5", Toast.LENGTH_SHORT).show()
        }
        binding.buttonInfo.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            myDialogFragment.show(supportFragmentManager, "myDialog")
        }
    }

    private fun snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
        Snackbar.make(binding.root, message, duration).show()
    }

    override fun onClickItem(message: String) {
        snack(message)
    }
}

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("TestDialog")
                    .setMessage("Lorem text ")
                    .setIcon(R.drawable.ic_about)
                    .setPositiveButton("ok") { dialog, _ ->
                        dialog.cancel()
                    }
            builder.create()
        } ?: throw IllegalStateException("error")
    }
}

interface OnClick {
    fun onClickItem(message: String)
}

class ItemDecorationCustomMargins(
        private val left: Int = 0,
        private val top: Int = 0,
        private val right: Int = 0,
        private val bottom: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(
                dip(view.context, left),
                dip(view.context, top),
                dip(view.context, right),
                dip(view.context, bottom)
        )

    }

    private fun dip(context: Context, dp: Int) =
            (dp * (context.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt();

}
