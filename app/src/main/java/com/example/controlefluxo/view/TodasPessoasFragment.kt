package com.example.controlefluxo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.controlefluxo.databinding.FragmentTodasPessoasBinding
import com.example.controlefluxo.viewmodel.PessoaFormularioViewModel
import com.example.controlefluxo.viewmodel.TodasPessoasViewModel

class TodasPessoasFragment : Fragment() {

    private var _binding: FragmentTodasPessoasBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TodasPessoasViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(TodasPessoasViewModel::class.java)

        _binding = FragmentTodasPessoasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.getAll()

        observe()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.pessoas.observe(viewLifecycleOwner) {

        }

    }
}