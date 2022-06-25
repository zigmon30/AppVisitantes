package com.example.controlefluxo.constants

class DataBaseConstants private constructor(){

    object PESSOA {
        const val ID = "pessoaid"
        const val TABELA_NOME = "Pessoa"

        object COLUNAS {
            const val ID = "id"
            const val NOME = "nome"
            const val SITUACAO = "situacao"
        }
    }
}