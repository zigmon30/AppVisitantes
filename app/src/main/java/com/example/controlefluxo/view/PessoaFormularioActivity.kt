package com.example.controlefluxo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.controlefluxo.R
import com.example.controlefluxo.databinding.ActivityPessoaFormularioBinding
import com.example.controlefluxo.viewmodel.PessoaFormularioViewModel

class PessoaFormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPessoaFormularioBinding
    private lateinit var viewModel: PessoaFormularioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPessoaFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PessoaFormularioViewModel::class.java)

        binding.botaoSalvar.setOnClickListener(this)
        binding.radioAutorizado.isChecked = true  // ja marca uma opção como padrão
    }

    override fun onClick(v: View) {
        if (v.id == R.id.botao_salvar) {

        }
    }
}