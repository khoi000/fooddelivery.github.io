package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentOnboardingOneBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardingOneFragment : Fragment() {
    lateinit var binding: FragmentOnboardingOneBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingOneBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnScanQr.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_onboardingOneFragment_to_welcomeFragment)
        }
    }
}