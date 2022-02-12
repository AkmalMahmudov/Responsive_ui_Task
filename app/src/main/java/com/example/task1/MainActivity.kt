package com.example.task1

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        val windowsManager =
            this.getSystemService(WINDOW_SERVICE) as WindowManager
        windowsManager.defaultDisplay.getMetrics(displayMetrics)
        val deviceWidth = displayMetrics.widthPixels
        val margin = 91.toPx
        val width = ((deviceWidth - margin) / 2.4).toInt()

        val list = listOf(
            ItemData("Food", "45$"),
            ItemData("Coffee", "32$"),
            ItemData("Fruits", "14$"),
            ItemData("Drinks", "5$"),
            ItemData("Cosmetics", "16$")
        )
        adapter = ItemAdapter(list, width)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter

    }
}