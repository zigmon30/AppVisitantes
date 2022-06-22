package com.example.controlefluxo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.repositorio.PessoaRepositorio

class TodasPessoasViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio = PessoaRepositorio.getInstance(application.applicationContext)

    private val listaPessoasTodas = MutableLiveData<List<PessoaModel>>()
    val pessoas: LiveData<List<PessoaModel>> = listaPessoasTodas

    fun getAll() {
        repositorio.exibirTodasPessoas()
        listaPessoasTodas.value = repositorio.exibirTodasPessoas()

    }
}