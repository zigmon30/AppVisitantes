package com.example.controlefluxo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.controlefluxo.R
import com.example.controlefluxo.constants.DataBaseConstants
import com.example.controlefluxo.databinding.ActivityPessoaFormularioBinding
import com.example.controlefluxo.model.PessoaModel
import com.example.controlefluxo.viewmodel.PessoaFormularioViewModel

class PessoaFormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPessoaFormularioBinding
    private lateinit var viewModel: PessoaFormularioViewModel

    private var pessoaId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPessoaFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PessoaFormularioViewModel::class.java)

        binding.botaoSalvar.setOnClickListener(this)
        binding.radioAutorizado.isChecked = true  // ja marca uma opção como padrão

        observe()
        carregarDados()


    }

    override fun onClick(v: View) {
        if (v.id == R.id.botao_salvar) {
            val nome = binding.editNome.text.toString()
            val situacao = binding.radioAutorizado.isChecked

            val model = PessoaModel(pessoaId, nome, situacao)
            viewModel.salvar(model)
            finish()

        }
    }

    private fun observe() {
        viewModel.pessoa.observe(this, Observer {
            binding.editNome.setText(it.nome)
            if (it.situacao) {
                binding.radioAutorizado.isChecked = true

            } else {
                binding.radioBloqueado.isChecked = true
            }
        })

        viewModel.salvarPessoa.observe(this, Observer {
           if (it != "") {
               Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()

               finish()
           }
        })
    }

    private fun carregarDados() {
        val bundle = intent.extras
        if (bundle != null) {
            pessoaId = bundle.getInt(DataBaseConstants.PESSOA.ID)
            viewModel.get(pessoaId)
        }
    }
}