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
import com.example.fooddelivery.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnlogin.setOnClickListener {

            val email = DataStore.emailInfo
            val pass = DataStore.passInfo

            var newmail = binding.editTextTextEmailAddress.text.toString().trim()
            var newpass = binding.editTextTextPassword.text.toString().trim()
            viewModel.checkEmailPasswordlogin(email, pass, newmail, newpass )


        }
        binding.textView4.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_loginFragment2_to_signUpFragment)
        }
        listenSuccessEvent()
        listenErrorEvent()
    }

    private fun listenSuccessEvent() {
        viewModel.successLiveData.observe(viewLifecycleOwner) {isLoginSuccess->
            if(isLoginSuccess){

                val email = binding.editTextTextEmailAddress
                val pass = binding.editTextTextPassword

                /*var email = email.text.toString().trim()
                var pass = pass.text.toString().trim()*/
                val bundle = Bundle()
                bundle.putString("email",email.text.toString().trim())
                bundle.putString("password",pass.text.toString().trim())

                val controller = findNavController()
                controller.navigate(R.id.action_loginFragment2_to_restuarantFragment)
            }
        }
    }

    private fun listenErrorEvent() {
        viewModel.errorLiveData.observe(viewLifecycleOwner) {LoginFailed->
            Toast.makeText(this@LoginFragment.requireContext(), LoginFailed, Toast.LENGTH_SHORT).show()
        }
    }
}