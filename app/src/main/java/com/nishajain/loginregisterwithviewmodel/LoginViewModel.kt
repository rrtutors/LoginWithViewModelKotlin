package com.nishajain.loginregisterwithviewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel

class LoginViewModel(private val listener: LoginResultCallBacks) : ViewModel() {
    private val user: LoginUser

    init {
        this.user = LoginUser("", "")
    }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Code what you want to show before edit the email box
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Code what you want to show on text Changed in email box

            }

        }


    //create function to set Password after user finish enter text
    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Code what you want to show before edit the password box

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Code what you want to show on text Changed in password box

            }

        }

    fun onLoginClicked(v: View) {
        val loginCode: Int = user.isDataValid()
        if (loginCode == 0)
            listener.onError("Enter Email ID")
        else if (loginCode == 1)
            listener.onError("Invalid Email")
        else if (loginCode == 2)
            listener.onError("Password must be greater than 5")
        else
            listener.onSuccess("Success")
    }

}