package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.ActivityRestuarantBinding


class Restuarant : AppCompatActivity() {
    lateinit var binding: ActivityRestuarantBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: Restaurant_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_restuarant)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val dataSet = DataStore.getDataSet()
        val adapter = Restaurant_Adapter(dataSet)
        val layoutManager = LinearLayoutManager(this )
        binding.RVRestaurantName.layoutManager = layoutManager
        binding.RVRestaurantName.adapter = adapter

        binding.button6.setOnClickListener {
            val layoutManager = LinearLayoutManager(this)
            binding.RVRestaurantName.layoutManager = layoutManager
            binding.RVRestaurantName.adapter = adapter
        }
        binding.button7.setOnClickListener {
            val layoutManager = GridLayoutManager(this, 2)
            binding.RVRestaurantName.layoutManager = layoutManager
            binding.RVRestaurantName.adapter = adapter
        }


    }
    override fun onStart() {
        super.onStart()
        viewModel.getData()
    }
}