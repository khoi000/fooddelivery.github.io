package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.databinding.ActivityLoginBinding
import com.example.fooddelivery.databinding.ActivitySignUpBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LOGIN-ACT", "onCreate")
        //setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val btnLogin = binding.btnSignup
        val editTextTextEmailAddress = binding.editTextTextEmailAddress
        val editTextNumberPassword = binding.editTextNumberPassword
        val textView10 = binding.textView10

        textView10.setOnClickListener {
            val intent = Intent( this@Login, SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            /*val intent = Intent(this@Login,ProfileActivity::class.java)
            val bundle = Bundle()
            bundle.putString("email",editTextTextEmailAddress.text.toString().trim())
            bundle.putString("password",editTextNumberPassword.text.toString().trim())
            intent.putExtras(bundle)
            if (editTextTextEmailAddress.text.toString().trim() == "ronaldo@gmail.com" && editTextNumberPassword.text.toString().trim() == "123456") {*/

            val email = DataStore.emailInfo
            val pass = DataStore.passInfo

            var newmail = editTextTextEmailAddress.text.toString().trim()
            var newpass = editTextNumberPassword.text.toString().trim()
            viewModel.checkEmailPasswordlogin(email, pass, newmail, newpass )

                //startActivity(intent)

            }
        listenSuccessEvent()
        listenErrorEvent()
        }

    private fun listenSuccessEvent() {
        viewModel.successLiveData.observe(this) {isLoginSuccess->
                if(isLoginSuccess){

                    val email = binding.editTextTextEmailAddress
                    val pass = binding.editTextNumberPassword

                    /*var email = email.text.toString().trim()
                    var pass = pass.text.toString().trim()*/
                    val bundle = Bundle()
                    bundle.putString("email",email.text.toString().trim())
                    bundle.putString("password",pass.text.toString().trim())

                    val intent = Intent(this@Login,ProfileActivity::class.java)
                    intent.putExtras(bundle)

                    startActivity(intent)
                }
            }
        }

    private fun listenErrorEvent() {
        viewModel.errorLiveData.observe(this) {LoginFailed->
                Toast.makeText(this, LoginFailed, Toast.LENGTH_SHORT).show()
            }
        }


    override fun onStart() {
        super.onStart()
        Log.e("LOGIN-ACT", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LOGIN-ACT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LOGIN-ACT", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LOGIN-ACT", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LOGIN-ACT", "onDestroy")
    }

}