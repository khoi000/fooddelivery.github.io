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
        Log.e("MAIN-ACT", "onCreate")
        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.btnSignup)
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextNumberPassword = findViewById<EditText>(R.id.editTextNumberPassword)
        val textView = findViewById<TextView>(R.id.textView8)
        val textView4 = findViewById<TextView>(R.id.textView4)
        btnLogin.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString().trim()
            val pass = editTextNumberPassword.text.toString().trim()
            textView.text = "$email -- $pass"
        }
        textView4.setOnClickListener {
            val intent = Intent( this@Login, SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val intent = Intent( this@Login, VerificationCode::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("MAIN-ACT", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MAIN-ACT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MAIN-ACT", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MAIN-ACT", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MAIN-ACT", "onDestroy")
    }

}