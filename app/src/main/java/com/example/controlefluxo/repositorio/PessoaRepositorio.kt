package com.example.controlefluxo.repositorio

import android.content.ContentValues
import android.content.Context
import com.example.controlefluxo.constants.DataBaseConstants
import com.example.controlefluxo.model.PessoaModel

class PessoaRepositorio private constructor(context: Context) {

    private val pessoaDataBase = PessoaDataBase(context)

    //padrão singleton
    companion object {
        private lateinit var repositorio: PessoaRepositorio

        fun getInstance(context: Context): PessoaRepositorio {
            if (!Companion::repositorio.isInitialized) {
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

    fun get(id: Int): PessoaModel? {

        var pessoa : PessoaModel? = null
        try {
            val db = pessoaDataBase.readableDatabase

            val projetar = arrayOf(
                DataBaseConstants.PESSOA.COLUNAS.ID,
                DataBaseConstants.PESSOA.COLUNAS.NOME,
                DataBaseConstants.PESSOA.COLUNAS.SITUACAO
            )

            val selection = DataBaseConstants.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(
                DataBaseConstants.PESSOA.TABELA_NOME,
                projetar,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.NOME))
                    val situacao =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.SITUACAO))

                    pessoa = PessoaModel(id, nome, situacao == 1)
                }
            }

            cursor.close()

        } catch (e: Exception) {
            return pessoa
        }
        return pessoa


    }

    fun exibirTodasPessoas(): List<PessoaModel> {

        val list = mutableListOf<PessoaModel>()
        try {
            val db = pessoaDataBase.readableDatabase

            val projetar = arrayOf(
                DataBaseConstants.PESSOA.COLUNAS.ID,
                DataBaseConstants.PESSOA.COLUNAS.NOME,
                DataBaseConstants.PESSOA.COLUNAS.SITUACAO
            )

            val cursor = db.query(
                DataBaseConstants.PESSOA.TABELA_NOME,
                projetar,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.ID))
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.NOME))
                    val situacao =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.SITUACAO))

                    list.add(PessoaModel(id, nome, situacao == 1))
                }
            }

            cursor.close()

        } catch (e: Exception) {
            return list
        }
        return list


    }

    fun exibirPessoasLiberadas(): List<PessoaModel> {

        val list = mutableListOf<PessoaModel>()
        try {
            val db = pessoaDataBase.readableDatabase


            val cursor = db.rawQuery("select id, nome, situacao from Pessoa where situacao = 1", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.ID))
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.NOME))
                    val situacao =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.SITUACAO))

                    list.add(PessoaModel(id, nome, situacao == 1))
                }
            }

            cursor.close()

        } catch (e: Exception) {
            return list
        }
        return list


    }

    fun exibirPessoasBloqueadas(): List<PessoaModel> {

        val list = mutableListOf<PessoaModel>()
        try {
            val db = pessoaDataBase.readableDatabase


            val cursor = db.rawQuery("select id, nome, situacao from Pessoa where situacao = 0", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.ID))
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.NOME))
                    val situacao =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PESSOA.COLUNAS.SITUACAO))

                    list.add(PessoaModel(id, nome, situacao == 1))
                }
            }

            cursor.close()

        } catch (e: Exception) {
            return list
        }
        return list


    }
}