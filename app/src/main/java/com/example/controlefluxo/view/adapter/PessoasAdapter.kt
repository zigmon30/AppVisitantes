package com.example.controlefluxo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controlefluxo.databinding.RowPessoaBinding
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.view.viewholder.PessoasViewHolder

class PessoasAdapter : RecyclerView.Adapter<PessoasViewHolder> (){

    private var listaPessoas: List<PessoaModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoasViewHolder {
        val item = RowPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoasViewHolder(item)

    }

    override fun onBindViewHolder(holder: PessoasViewHolder, position: Int) {
        holder.bind(listaPessoas[position])
    }

    override fun getItemCount(): Int {
        return listaPessoas.count()
    }

    fun atualizarPessoas(list: List<PessoaModel>) {

        listaPessoas = list
        notifyDataSetChanged()

    }
}