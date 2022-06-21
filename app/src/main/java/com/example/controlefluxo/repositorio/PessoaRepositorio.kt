package com.example.controlefluxo.repositorio

class PessoaRepositorio private constructor(){

    

    //padrão singleton
    companion object {
        private lateinit var repositorio: PessoaRepositorio

        fun getInstance(): PessoaRepositorio {
            if (!Companion::repositorio.isInitialized){
                repositorio = PessoaRepositorio()
            }
            return repositorio

        }

    }

    fun salvar() {

    }
}