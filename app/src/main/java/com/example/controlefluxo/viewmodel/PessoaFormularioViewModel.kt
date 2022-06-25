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

    private val _salvarPessoa = MutableLiveData<String>()
    val salvarPessoa: LiveData<String> = _salvarPessoa

    fun salvar(pessoa: PessoaModel) {
        if (pessoa.id == 0) {
            if (repositorio.inserir(pessoa)) {
                _salvarPessoa.value = "ISERIDO PESSOA COM SUCESSO"
            } else {
                _salvarPessoa.value = "FALHA"
            }
        } else {
            if (repositorio.atualizar(pessoa)) {
                _salvarPessoa.value = "ATUALIZADO PESSOA COM SUCESSO"
            } else {
                _salvarPessoa.value = "FALHA"
            }
        }
    }

    fun get(id: Int) {
        pessoaModel.value = repositorio.get(id)

    }


}