package com.example.controlefluxo.view.viewholder


import androidx.recyclerview.widget.RecyclerView
import com.example.controlefluxo.databinding.RowPessoaBinding
import com.example.controlefluxo.model.PessoaModel

class PessoasViewHolder(private val bind: RowPessoaBinding) : RecyclerView.ViewHolder(bind.root) {
    fun bind(pessoa: PessoaModel) {
        bind.textNome.text = pessoa.nome

    }
}