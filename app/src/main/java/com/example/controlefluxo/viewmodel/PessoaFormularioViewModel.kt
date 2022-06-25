package com.example.controlefluxo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.repositorio.PessoaRepositorio

class PessoaFormularioViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio = PessoaRepositorio.getInstance(application)

    private val pessoaModel = MutableLiveData<PessoaModel>()
    val pessoa: LiveData<PessoaModel> = pessoaModel

    fun salvar(pessoa: PessoaModel) {
        if (pessoa.id == 0) {
            repositorio.inserir(pessoa)
    } else {
            repositorio.atualizar(pessoa)
        }
    }

    fun get(id: Int) {
        pessoaModel.value = repositorio.get(id)

    }


}