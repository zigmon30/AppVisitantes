package com.example.controlefluxo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlefluxo.databinding.FragmentTodasPessoasBinding
import com.example.controlefluxo.view.adapter.PessoasAdapter
import com.example.controlefluxo.viewmodel.PessoaFormularioViewModel
import com.example.controlefluxo.viewmodel.TodasPessoasViewModel

class TodasPessoasFragment : Fragment() {

    private var _binding: FragmentTodasPessoasBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TodasPessoasViewModel
    private val adapter = PessoasAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {

        viewModel = ViewModelProvider(this).get(TodasPessoasViewModel::class.java)
        _binding = FragmentTodasPessoasBinding.inflate(inflater, container, false)

        //layout
        binding.recyclePessoasTodas.layoutManager = LinearLayoutManager(context)

        //adapter
        binding.recyclePessoasTodas.adapter = adapter

        viewModel.getAll()

        observe()

        return binding.root
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