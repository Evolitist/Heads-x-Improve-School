package com.example.homework5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.homework5.databinding.ActivityServicesListBinding
import com.example.homework5.ui.adapters.ServiceItemListAdapter
import com.example.homework5.ui.adapters.decorations.ServiceListDecoration
import data.ServiceDiscount
import utils.OnServiceItemClickedListener

class ServicesListActivity : AppCompatActivity(), OnServiceItemClickedListener {

    private lateinit var binding: ActivityServicesListBinding

    //Не знал куда засунуть
    private val toolbarImageUrl =
        "https://cdn-p.cian.site/images/3/289/215/pifagor-novosibirsk-jk-512982382-6.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesListBinding.inflate(layoutInflater)
        val dataList = ServiceDiscount.getSampleList()
        val rvAdapter = ServiceItemListAdapter(this@ServicesListActivity)

        with(binding) {
            recyclerView.apply {
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(this@ServicesListActivity).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }
            }.addItemDecoration(ServiceListDecoration())
            rvAdapter.submitList(dataList)
            Glide.with(this@ServicesListActivity).load(toolbarImageUrl).into(collapsingToolbarImage)
        }

        setContentView(binding.root)
    }

    override fun onServiceOfferClicked() {
        //Обработка нажатия на "Предложить услугу"
    }

    override fun onServiceItemClicked() {
        //Обработка нажатия на 3 точки у элементов списка
    }

    override fun onServiceHeaderClicked() {
        //Обработка нажатия на "ВСЕ" в шапке списка
    }
}