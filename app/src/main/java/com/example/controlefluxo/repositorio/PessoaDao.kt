package com.example.controlefluxo.repositorio

import androidx.room.*
import com.example.controlefluxo.model.PessoaModel


@Dao
interface PessoaDao {

    @Insert
    fun inserir(pessoa: PessoaModel) : Long

    @Update
    fun atualizar(pessoa: PessoaModel) : Int

    @Delete
    fun deletar(pessoa: PessoaModel)

    @Query("select * from Pessoas where id = :id")
    fun get(id: Int): PessoaModel

    @Query("select * from Pessoas")
    fun exibirTodasPessoas(): List<PessoaModel>

    @Query("select * from Pessoas where situacao = 1")
    fun exibirPessoasLiberadas(): List<PessoaModel>

    @Query("select * from Pessoas where situacao = 0")
    fun exibirPessoasBloqueadas(): List<PessoaModel>

    /*
    @Transaction
    @Query("SELECT * FROM Pessoas")
    fun DescricaoAtividadePessoa(): List<AtividadesPessoa> */
}