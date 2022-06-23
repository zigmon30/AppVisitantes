package com.example.controlefluxo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controlefluxo.databinding.RowPessoaBinding
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.view.listener.OnPessoaListener
import com.example.controlefluxo.view.viewholder.PessoasViewHolder

class PessoasAdapter : RecyclerView.Adapter<PessoasViewHolder> (){

    companion object {
        var countCreate = 0
        var countBinding = 0
    }

    private var listaPessoas: List<PessoaModel> = listOf()
    private lateinit var listener: OnPessoaListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoasViewHolder {
        countCreate++
        val item = RowPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoasViewHolder(item, listener)

    }

    override fun onBindViewHolder(holder: PessoasViewHolder, position: Int) {
        countBinding++
        holder.bind(listaPessoas[position])
    }

    override fun getItemCount(): Int {
        return listaPessoas.count()
    }

    fun atualizarPessoas(list: List<PessoaModel>) {

        listaPessoas = list
        notifyDataSetChanged()

    }

    fun attachListener(pessoaListener: OnPessoaListener) {
        listener = pessoaListener
    }
}