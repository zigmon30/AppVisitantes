package com.example.controlefluxo.model

import androidx.room.*
@Entity(tableName = "Pessoas")     //nome da tabela pessoas

class PessoaModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "nome")
    var nome: String = ""

    @ColumnInfo(name = "situacao")
    var situacao: Boolean = false
}

/*

@Entity(tableName = "Tarefas")     //nome da tabela O que as pessoas farao de atividades

class Tarefas {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_tarefa")
    var id: Int = 0

    @ColumnInfo(name = "tarefa")
    var tarefa: String = ""
}

@Entity(tableName = "AtividadesPessoa")     //nome da tabela que as pessoas fizeram
class AtividadesPessoa (
    @Embedded val pessoa: PessoaModel,
            @Relation(
                parentColumn = "id",
                entityColumn = "id_tarefa"
            )
            val Tarefas : List<Tarefas>
)

 */