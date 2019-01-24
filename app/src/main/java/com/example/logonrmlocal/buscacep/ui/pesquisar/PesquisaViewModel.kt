package com.example.logonrmlocal.buscacep.ui.pesquisar

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.buscacep.model.Endereco
import com.example.logonrmlocal.buscacep.repository.EnderecoRepository

class PesquisaViewModel: ViewModel () {

    val enderecoRepository = EnderecoRepository()

    val endereco = MutableLiveData<Endereco>()
    val mensagemerro= MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun buscar (cep: String) {

        isLoading.value = true


        enderecoRepository.buscar(
                cep,
                onComplete = {
                    endereco.value = it
                    mensagemerro.value = ""
                    isLoading.value = false
                },

                onError = {
                    endereco.value = null
                    mensagemerro.value = it?.message
                    isLoading.value=false

                }
        )

    }
}