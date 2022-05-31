package com.example.visitantes.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlockedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bloquedos"
    }
    val text: LiveData<String> = _text
}