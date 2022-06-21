package com.example.controlefluxo.repositorio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class PessoaDataBase(context: Context): SQLiteOpenHelper(context, NOME, null, VERSAO) {

        companion object {
            private const val NOME = "controleFluxoPessoadb"
            private const val VERSAO = 1

        }

    override fun onCreate(db: SQLiteDatabase) {
        //criação do banco de dados
        db.execSQL("create table Pessoa (" +
                "id integer primary key autoincrement, " +
                "nome text, " +
                " situacao integer);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}