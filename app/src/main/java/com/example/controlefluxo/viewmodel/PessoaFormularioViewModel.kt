package com.example.controlefluxo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.repositorio.PessoaRepositorio

class PessoaFormularioViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio = PessoaRepositorio.getInstance(application)

    fun inserir(pessoa: PessoaModel) {
        repositorio.inserir(pessoa)

    }


}