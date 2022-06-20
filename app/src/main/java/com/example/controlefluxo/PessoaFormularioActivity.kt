package com.example.controlefluxo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.lifecycle.ViewModelProvider
import com.example.controlefluxo.databinding.ActivityMainBinding.inflate
import com.example.controlefluxo.databinding.ActivityPessoaFormularioBinding
import com.example.controlefluxo.databinding.ActivityPessoaFormularioBinding.inflate
import com.example.controlefluxo.databinding.FragmentBloqueadoBinding

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