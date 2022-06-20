package com.example.controlefluxo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodasPessoasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Essa é uma Fragmente de Todas as pessoas"
    }
    val text: LiveData<String> = _text
}