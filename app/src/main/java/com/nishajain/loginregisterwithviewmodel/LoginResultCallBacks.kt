package com.nishajain.loginregisterwithviewmodel

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}