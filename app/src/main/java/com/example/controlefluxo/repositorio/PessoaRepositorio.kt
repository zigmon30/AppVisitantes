package com.example.controlefluxo.repositorio

import android.content.ContentValues
import android.content.Context
import com.example.controlefluxo.model.PessoaModel

class PessoaRepositorio private constructor(context: Context){

    private val pessoaDataBase = PessoaDataBase(context)

    //padrão singleton
    companion object {
        private lateinit var repositorio: PessoaRepositorio

        fun getInstance(context: Context): PessoaRepositorio {
            if (!Companion::repositorio.isInitialized){
                repositorio = PessoaRepositorio(context)
            }
            return repositorio

        }

    }

    fun inserir(pessoa: PessoaModel): Boolean {
        return try {
            val db = pessoaDataBase.writableDatabase

            val situacao = if (pessoa.situacao) 1 else 0

            val values = ContentValues()
            values.put("nome", pessoa.nome)
            values.put("situacao", situacao)

            db.insert("Pessoa", null, values)
            true

        } catch (e: Exception) {
            false

        }

    }

    fun atualizar() {

    }
}