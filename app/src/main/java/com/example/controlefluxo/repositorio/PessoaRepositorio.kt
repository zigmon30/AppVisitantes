package com.example.controlefluxo.repositorio

import android.content.ContentValues
import android.content.Context
import com.example.controlefluxo.constants.DataBaseConstants
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
            values.put(DataBaseConstants.PESSOA.COLUNAS.NOME, pessoa.nome)
            values.put(DataBaseConstants.PESSOA.COLUNAS.SITUACAO, situacao)

            db.insert(DataBaseConstants.PESSOA.TABELA_NOME, null, values)
            true

        } catch (e: Exception) {
            false

        }

    }

    fun atualizar(pessoa: PessoaModel): Boolean {
        return try {
            val db = pessoaDataBase.writableDatabase
            val situacao = if (pessoa.situacao) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.PESSOA.COLUNAS.SITUACAO, situacao)
            values.put(DataBaseConstants.PESSOA.COLUNAS.NOME, pessoa.nome)

            val selection = DataBaseConstants.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(pessoa.id.toString())

            db.update(DataBaseConstants.PESSOA.TABELA_NOME, values, selection, args)
            true
        } catch (e: Exception) {
            false

        }

    }

    fun deletar(id: Int): Boolean {
        return try {
            val db = pessoaDataBase.writableDatabase


            val selection = DataBaseConstants.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.PESSOA.TABELA_NOME, selection, args)
            true
        } catch (e: Exception) {
            false

        }

    }
}