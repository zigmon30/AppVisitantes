package com.example.controlefluxo.view.viewholder


import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.controlefluxo.databinding.RowPessoaBinding
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.view.listener.OnPessoaListener

class PessoasViewHolder(
    private val bind: RowPessoaBinding,
    private val listener: OnPessoaListener
) :
    RecyclerView.ViewHolder(bind.root) {
    fun bind(pessoa: PessoaModel) {
        bind.textNome.text = pessoa.nome

        bind.textNome.setOnClickListener {
            listener.onClick(pessoa.id)

            bind.textNome.setOnClickListener {

                AlertDialog.Builder(itemView.context)
                    .setTitle("Remoção de Pessoa")
                    .setMessage("Tem certeza que deseja remover?")
                    .setPositiveButton("Sim") { dialog, which ->
                        listener.OnDelete(pessoa.id)
                    }
                    .setNeutralButton("Cancelar", null)

                    .create()
                    .show()
                true
            }

        }

    }
}