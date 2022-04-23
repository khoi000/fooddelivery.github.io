package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentRestuarantBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RestuarantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestuarantFragment : Fragment() {
    lateinit var binding: FragmentRestuarantBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: Restaurant_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestuarantBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button9.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_restuarantFragment_to_profileFragment)
        }

        val dataSet = DataStore.getDataSet()
        val adapter = Restaurant_Adapter(dataSet)
        val layoutManager = LinearLayoutManager(this@RestuarantFragment.requireContext())
        binding.RVRestaurantName.layoutManager = layoutManager
        binding.RVRestaurantName.adapter = adapter

        binding.button6.setOnClickListener {
            val layoutManager = LinearLayoutManager(this@RestuarantFragment.requireContext())
            binding.RVRestaurantName.layoutManager = layoutManager
            binding.RVRestaurantName.adapter = adapter
        }
        binding.button7.setOnClickListener {
            val layoutManager = GridLayoutManager(this@RestuarantFragment.requireContext(), 2)
            binding.RVRestaurantName.layoutManager = layoutManager
            binding.RVRestaurantName.adapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getData()
    }
}