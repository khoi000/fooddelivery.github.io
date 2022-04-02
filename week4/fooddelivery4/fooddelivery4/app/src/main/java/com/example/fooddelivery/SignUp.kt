package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.databinding.ActivitySignUpBinding


class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("SIGNUP-ACT", "onCreate")
        //setContentView(R.layout.activity_sign_up)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val btnSignup = binding.btnSignup
        val editTextTextPersonName = binding.editTextTextPersonName
        val editEmailAddress = binding.editEmailAddress
        val editTextPassword = binding.editTextPassword
        val textView9 = binding.textView9
        val textView4 = binding.Forgotpass

        btnSignup.setOnClickListener {
            val name = editTextTextPersonName.text.toString().trim()
            val email = editEmailAddress.text.toString().trim()
            val pass = editTextPassword.text.toString().trim()
            textView9.text = "$name -- $email -- $pass"

            //kiem tra mail
            //val isEmailValid = isEmailValid(email)
            viewModel.checkEmailAndPasswordIsValid(email, pass)

            /*if (resp.isSuccess) {
                val intent = Intent(this@SignUp, Login::class.java)
                startActivity(intent)
            }
            else {
                if (resp.errorValid == ErrorValid.EMAIL_ERROR)
                Toast.makeText(this, "email khong hop le", Toast.LENGTH_SHORT).show()
            }
            else if (resp.errorValid == ErrorValid.EMAIL_PASSWORD){
                Toast.makeText(this, "password khong hop le", Toast.LENGTH_SHORT).show()
            }*/
        }

        textView4.setOnClickListener {
            val intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }

        listenSuccessEvent()
        listenErrorEvent()
    }
    private fun listenSuccessEvent() {
        viewModel.successLiveData.observe(this) { isSignUpSuccess ->
            if (isSignUpSuccess) {
                val editTextTextPersonName = binding.editTextTextPersonName
                val editEmailAddress = binding.editEmailAddress
                val editTextPassword = binding.editTextPassword

                var email = editEmailAddress.text.toString().trim()
                var pass = editTextPassword.text.toString().trim()
                DataStore.emailInfo = email
                DataStore.passInfo = pass

                val intent = Intent(this@SignUp, Login::class.java)
                startActivity(intent)
            }
        }
    }
    private fun listenErrorEvent() {
        viewModel.errorLiveData.observe(this) { errMessage ->
            Toast.makeText(this, errMessage, Toast.LENGTH_SHORT).show()
        }
    }



    override fun onStart() {
        super.onStart()
        Log.e("SIGNUP-ACT", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SIGNUP-ACT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SIGNUP-ACT", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SIGNUP-ACT", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SIGNUP-ACT", "onDestroy")
    }

}