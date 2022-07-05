package com.example.controlefluxo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controlefluxo.constants.DataBaseConstants
import com.example.controlefluxo.databinding.FragmentTodasPessoasBinding
import com.example.controlefluxo.view.adapter.PessoasAdapter
import com.example.controlefluxo.view.listener.OnPessoaListener
import com.example.controlefluxo.viewmodel.PessoasViewModel

class TodasPessoasFragment : Fragment() {

    private var _binding: FragmentTodasPessoasBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PessoasViewModel
    private val adapter = PessoasAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        viewModel = ViewModelProvider(this).get(PessoasViewModel::class.java)
        _binding = FragmentTodasPessoasBinding.inflate(inflater, container, false)

        binding.recyclePessoas.layoutManager = LinearLayoutManager(context)
        binding.recyclePessoas.adapter = adapter

        val listener = object : OnPessoaListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, PessoaFormularioActivity::class.java)
                val bundle = Bundle()

                bundle.putInt(DataBaseConstants.PESSOA.ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun OnDelete(id: Int) {
                viewModel.deletar(id)
                viewModel.getAll()

            }

        }

        adapter.attachListener(listener)
        observe()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.pessoas.observe(viewLifecycleOwner) {
            adapter.atualizarPessoas(it)

        }

    }
}