package com.example.controlefluxo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.controlefluxo.repositorio.PessoaRepositorio

class PessoaFormularioViewModel : ViewModel() {
    private val repositorio = PessoaRepositorio.getInstance()


}