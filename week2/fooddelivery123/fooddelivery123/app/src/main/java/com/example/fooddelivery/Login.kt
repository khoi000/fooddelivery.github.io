package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LOGIN-ACT", "onCreate")
        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.btnSignup)
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextNumberPassword = findViewById<EditText>(R.id.editTextNumberPassword)
        val textView = findViewById<TextView>(R.id.textView8)
        val textView4 = findViewById<TextView>(R.id.Forgotpass)

        btnLogin.setOnClickListener {
            val intent = Intent(this@Login,ProfileActivity::class.java)
            val bundle = Bundle()
            bundle.putString("email",editTextTextEmailAddress.text.toString().trim())
            bundle.putString("password",editTextNumberPassword.text.toString().trim())
            intent.putExtras(bundle)

            if (editTextTextEmailAddress.text.toString().trim() == "ronaldo@gmail.com" && editTextNumberPassword.text.toString().trim() == "123456") {
                startActivity(intent)
            }

        }
        textView4.setOnClickListener {
            val intent = Intent( this@Login, SignUp::class.java)
            startActivity(intent)
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