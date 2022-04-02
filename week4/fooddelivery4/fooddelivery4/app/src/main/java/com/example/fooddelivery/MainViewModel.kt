package com.example.fooddelivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.Validators.Companion.isEmailValid
import com.example.fooddelivery.model.Restaurant

/*enum class ErrorValid {
    EMAIL_ERROR,
    EMAIL_PASSWORD
}


data class Resp(val isSuccess: Boolean, val errorValid: ErrorValid?)*/

/*class MainViewModel() : ViewModel() {
    private var _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private var _successLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val successLiveData: LiveData<Boolean>
        get() = _successLiveData

    fun checkEmailPasswordIsValid(email: String, pass: String): Boolean {
        val isEmailValid = Validators.isEmailValid(email)
        val isPasswordvalid = Validators.isPasswordInvalid(pass)
        if (!isEmailValid) {
            //return Resp(false, ErrorValid.EMAIL_ERROR)
            _errorLiveData.postValue("email khong hop le")
            return
        }
        if (!isPasswordvalid) {
            //return Resp(false, ErrorValid.EMAIL_PASSWORD)
            _errorLiveData.postValue("password khong hop le")
            return
        }
        //return Resp(true)
        return _successLiveData.postValue(true)
    }
}*/

class MainViewModel() : ViewModel() {
    private var _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private var _successLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val successLiveData: LiveData<Boolean>
        get() = _successLiveData

    private var _listOfRestaurant: MutableLiveData<List<Restaurant>> = MutableLiveData()
    val listOfRestaurant: LiveData<List<Restaurant>>
        get() = _listOfRestaurant


    fun checkEmailAndPasswordIsValid(email: String, password: String) {
        //kiem tra email
        val isEmailValid = Validators.isEmailValid(email)
        //kiem tra password
        val isPasswordValid = Validators.isPasswordInvalid(password)
        if (!isEmailValid) {
            _errorLiveData.postValue("email khong hop le")
            return
        }
        if (!isPasswordValid) {
            _errorLiveData.postValue("password khong hop le, it nhat 8 ky tu , viet hoa, " + "viet thuong, ky tu dac biet")
            return
        }
        return _successLiveData.postValue(true)
    }

    fun checkEmailPasswordlogin(email: String, password: String, newmail: String, newpass: String) {
        //kiem tra email
        val isEmailValid = Validators.isEmailValid(email)
        //kiem tra password
        val isPasswordValid = Validators.isPasswordInvalid(password)

        /*if (!isEmailValid) {
            _errorLiveData.postValue("Email khong hop le")
            return
        }
        if (!isPasswordValid) {
            _errorLiveData.postValue("Pass khong hop le")
            return
        }*/
        if (!Validators.CompareToValidMail(email, newmail)) {
            _errorLiveData.postValue("sai Email !")
            return
        }
        if (!Validators.CompareToValidPass(password, newpass)) {
            _errorLiveData.postValue("sai pass")
            return
        }
        return _successLiveData.postValue(true)
    }

    fun getData() {
        val dataSet = DataStore.getDataSet()
        _listOfRestaurant.postValue(dataSet)
    }
}
