package com.example.homework_fragment_6

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_fragment_6.databinding.ViewPagerImageBinding

class ViewPagerAdapter(private val dataList: List<Drawable?>) :
        RecyclerView.Adapter<ViewPagerAdapter.PagerVH>() {

    class PagerVH(private val binding: ViewPagerImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setImagePager(image: Drawable?) {
            binding.imageView.setImageDrawable(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val binding = ViewPagerImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerVH(binding)
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        holder.setImagePager(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}