package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class OnboardingOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MAIN-ACT", "onCreate")
        setContentView(R.layout.activity_onboarding_one)
        val btn_scan_qr = findViewById<Button>(R.id.btn_scan_qr)
        btn_scan_qr.setOnClickListener {
            val intent = Intent( this@OnboardingOne, MainActivity::class.java)
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