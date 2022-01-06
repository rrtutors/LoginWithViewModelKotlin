package com.nishajain.loginregisterwithviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nishajain.loginregisterwithviewmodel.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }
}