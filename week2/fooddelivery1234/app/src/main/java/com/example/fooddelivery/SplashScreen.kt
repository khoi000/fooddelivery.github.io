package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MAIN-ACT", "onCreate")
        setContentView(R.layout.activity_splash_screen)
        val imageView17 = findViewById<ImageView>(R.id.imageView17)
        imageView17.setOnClickListener {
            val intent = Intent( this@SplashScreen, OnboardingOne::class.java)
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