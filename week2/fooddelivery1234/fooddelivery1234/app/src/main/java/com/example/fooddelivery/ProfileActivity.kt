package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("PROFILE-ACT", "onCreate")
        setContentView(R.layout.activity_profile)
        val bundle = intent.extras
        val btnLogout = findViewById<Button>(R.id.logoutBtn)
        val editinforbtn = findViewById<Button>(R.id.editinforbtn)
        lateinit var stringname: String
        lateinit var stringemail: String
        lateinit var stringphone: String
        val dialogLoginBtn = findViewById<Button>(R.id.dialogLoginBtn)
//        val dialogNameEt = findViewById<EditText>(R.id.dialogNameEt)
//        val dialogEmailEt = findViewById<EditText>(R.id.dialogEmailEt)
//        val dialogPhoneEt = findViewById<EditText>(R.id.dialogPhoneEt)
        val mainInFoTv = findViewById<TextView>(R.id.mainInFoTv)
//        val dialogCancelBtn = findViewById<Button>(R.id.dialogCancelBtn)
        bundle?.let {
            val email = it.getString("email")
            val password = it.getString("password")
            val emailTv = findViewById<TextView>(R.id.emailTv)
            emailTv.text = "$email - $password"
        }
        btnLogout.setOnClickListener {
            val intent = Intent( this@ProfileActivity, SplashScreen::class.java)
            startActivity(intent)
        }

            editinforbtn.setOnClickListener {
                //inflate the dialog with custom view
                val mDialogView = LayoutInflater.from(this@ProfileActivity).inflate(R.layout.login_dialog, null);
                //AlterDialogBuider
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setTitle("Edit Infor")
                //show dialog
            val mAlertDialog = mBuilder.show()
            //login button click of

                // one = (Button) dialogView.findViewById(R.id.button1);
                val btnsave = mDialogView.findViewById<Button>(R.id.dialogLoginBtn)
                val btnCancel = mDialogView.findViewById<Button>(R.id.dialogCancelBtn)
                val name = mDialogView.findViewById<EditText>(R.id.dialogNameEt)
                val email = mDialogView.findViewById<EditText>(R.id.dialogEmailEt)
                val phone = mDialogView.findViewById<EditText>(R.id.dialogPhoneEt)

                btnsave.setOnClickListener {
                    //dismiss dialog
                    mAlertDialog.dismiss()
                    //get text from EditTexts of custom layout


//                    val name = mDialogView.dialogNameEt.text.toString()
//                    val email = mDialogView.dialogEmailEt.text.toString()
//                    val password = mDialogView.dialogPasswEt.text.toString()
//                    //set the input text in TextView
                    stringname = name.text.toString().trim()
                    stringemail= email.text.toString().trim()
                    stringphone = phone.text.toString().trim()

                    mainInFoTv.setText("Name:"+ stringname +"\nEmail: "+ stringemail +"\nPhone: "+ stringphone)
                }
                btnCancel.setOnClickListener{
                    mAlertDialog.dismiss()
                }




//
////
//               }
//            //cancel
//            mDialogView.dialogCancelBtn.setOnClickListener {
//
//               mAlertDialog.dismiss()
//           }

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