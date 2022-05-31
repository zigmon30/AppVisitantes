package com.example.visitantes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllVisitorsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Todos"
    }
    val text: LiveData<String> = _text
}