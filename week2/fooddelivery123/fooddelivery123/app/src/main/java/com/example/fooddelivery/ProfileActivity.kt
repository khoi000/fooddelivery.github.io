package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("PROFILE-ACT", "onCreate")
        setContentView(R.layout.activity_profile)
        val bundle = intent.extras
        val btnLogout = findViewById<Button>(R.id.logoutBtn)
        val button5 = findViewById<Button>(R.id.button5)
        val editTextTextPersonName2 = findViewById<EditText>(R.id.editTextTextPersonName2)
        val editTextTextEmailAddress2 = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        //val textView10 = findViewById<EditText>(R.id.textView10)


        bundle?.let {
            val email = it.getString("email")
            val password = it.getString("password")
            val emailTv = findViewById<TextView>(R.id.emailTv)
            emailTv.text = "$email - $password"

        }

        button5.setOnClickListener {
            val mDialogView = LayoutInflater.from(this@ProfileActivity).inflate(R.layout.activity_edit_dialog, null)
            val mBuilder = androidx.appcompat.app.AlertDialog.Builder(this)
                .setView(mDialogView)
            val editProfileDialog = mBuilder.show()

            val editPersonName = mDialogView.findViewById<EditText>(R.id.editPersonName)
            val editEmailAddress = mDialogView.findViewById<EditText>(R.id.editEmailAddress)
            val editTextPhone1 = mDialogView.findViewById<EditText>(R.id.editTextPhone1)

            editPersonName.setText(editTextTextPersonName2.text)
            editEmailAddress.setText(editTextTextEmailAddress2.text)
            editTextPhone1.setText(editTextPhone.text)

            mDialogView.findViewById<Button>(R.id.btnyes).setOnClickListener {

                    editPersonName.setText(editTextTextPersonName2.text)
                    editEmailAddress.setText(editTextTextEmailAddress2.text)
                    editTextPhone1.setText(editTextPhone.text)
                    editProfileDialog.dismiss()
               // }
            }
            mDialogView.findViewById<Button>(R.id.btnedit).setOnClickListener{
                editProfileDialog.dismiss()
            }
        }


        btnLogout.setOnClickListener {
            val intent = Intent( this@ProfileActivity, SplashScreen::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("PROFILE-ACT", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("PROFILE-ACT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("PROFILE-ACT", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("PROFILE-ACT", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("PROFILE-ACT", "onDestroy")
    }
}