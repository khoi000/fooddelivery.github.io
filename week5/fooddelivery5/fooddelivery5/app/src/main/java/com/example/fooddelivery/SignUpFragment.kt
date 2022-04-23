package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentSignUpBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnSignup.setOnClickListener {
            val name = binding.editTextTextPersonName.text.toString().trim()
            val email = binding.editEmailAddress.text.toString().trim()
            val pass = binding.editTextPassword.text.toString().trim()
            viewModel.checkEmailAndPasswordIsValid(email, pass)
        }

        binding.Forgotpass.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_signUpFragment_to_loginFragment2)
        }

        listenSuccessEvent()
        listenErrorEvent()
    }
    private fun listenSuccessEvent() {
        viewModel.successLiveData.observe(viewLifecycleOwner) { isSignUpSuccess ->
            if (isSignUpSuccess) {
                val editTextTextPersonName = binding.editTextTextPersonName
                val editEmailAddress = binding.editEmailAddress
                val editTextPassword = binding.editTextPassword

                var email = editEmailAddress.text.toString().trim()
                var pass = editTextPassword.text.toString().trim()
                DataStore.emailInfo = email
                DataStore.passInfo = pass

                val controller = findNavController()
                controller.navigate(R.id.action_signUpFragment_to_loginFragment2)
            }
        }
    }
    private fun listenErrorEvent() {
        viewModel.errorLiveData.observe(viewLifecycleOwner) { errMessage ->
            Toast.makeText(this@SignUpFragment.requireContext(), errMessage, Toast.LENGTH_SHORT).show()
        }
    }
}