package com.example.task1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.databinding.ItemImageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ImageAdapter(private val ls: List<Int>, private val width: Int) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                image.layoutParams.height = width
                image.layoutParams.width = width
                image.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = ls.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

}