package com.example.task1

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.databinding.ItemBinding

class ItemAdapter(private val ls: List<ItemData>, private val width: Int) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                name.text = ls[position].name
                price.text = ls[position].price
                list2.adapter = ImageAdapter(
                    listOf(
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background
                    ), width
                )
                list2.layoutManager =
                    LinearLayoutManager(Application(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount() = ls.size
}