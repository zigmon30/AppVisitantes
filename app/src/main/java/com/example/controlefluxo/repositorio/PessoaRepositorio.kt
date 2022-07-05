package com.example.controlefluxo.repositorio


import android.content.Context
import com.example.controlefluxo.model.PessoaModel

class PessoaRepositorio(context: Context) {

    private val pessoaDataBase = PessoaDataBase.getDatabase(context).pessoaDao()

    fun inserir(pessoa: PessoaModel): Boolean {
        return pessoaDataBase.inserir(pessoa) > 0
    }

    fun atualizar(pessoa: PessoaModel): Boolean {
        return pessoaDataBase.atualizar(pessoa) > 0
    }

    fun deletar(id: Int) {
        val pessoa = get(id)
        pessoaDataBase.deletar(pessoa)
    }

    fun get(id: Int): PessoaModel {
        return pessoaDataBase.get(id)
    }

    fun exibirTodasPessoas(): List<PessoaModel> {
        return pessoaDataBase.exibirTodasPessoas()
    }

    fun exibirPessoasLiberadas(): List<PessoaModel> {
        return pessoaDataBase.exibirPessoasLiberadas()
    }

    fun exibirPessoasBloqueadas(): List<PessoaModel> {
        return pessoaDataBase.exibirPessoasBloqueadas()
    }
}