package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MAIN-ACT", "onCreate")
        setContentView(R.layout.activity_sign_up)
        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextNumberPassword = findViewById<EditText>(R.id.editTextNumberPassword)
        val textView9 = findViewById<TextView>(R.id.textView9)
        val textView4 = findViewById<TextView>(R.id.Forgotpass)
        btnSignup.setOnClickListener {
            val name = editTextTextPersonName.text.toString().trim()
            val email = editTextTextEmailAddress.text.toString().trim()
            val pass = editTextNumberPassword.text.toString().trim()
            textView9.text = "$name -- $email -- $pass"
        }
        textView4.setOnClickListener {
            val intent = Intent( this@SignUp, Login::class.java)
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