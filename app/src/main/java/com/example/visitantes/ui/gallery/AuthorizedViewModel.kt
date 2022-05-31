package com.example.visitantes.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthorizedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Autorizados"
    }
    val text: LiveData<String> = _text
}