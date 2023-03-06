package com.example.ukllagi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComModel: ViewModel() {
    private val iEmail = MutableLiveData<String>()
    private val iName = MutableLiveData<String>()

    val name: LiveData<String>
        get() = iName

    val email: LiveData<String>
        get() = iEmail

    fun setName(name: String) {
        iName.value = name
    }

    fun setEmail(email: String) {
        iEmail.value = email
    }
}