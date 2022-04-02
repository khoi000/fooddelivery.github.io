package com.example.fooddelivery

class Validators {
    companion object {
        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        }

        fun isPasswordInvalid(password: String): Boolean {
            //return password.length in 8..30
            if (password.length < 8) return false
            if (!password.matches(".*[A-Z].*".toRegex())) return false
            if (!password.matches(".*[a-z].*".toRegex())) return false
            if (!password.matches(".*[!@#\$%^&*()].*".toRegex())) return false
            return true;
        }

        fun CompareToValidMail(email: String, newmail : String): Boolean{
            return email == newmail
        }

        fun CompareToValidPass(password: String, newpass: String): Boolean{
            return password == newpass
        }
    }
}