package com.example.logonrmlocal.buscacep.model

import com.google.gson.annotations.SerializedName

class Endereco (

        val cep: String,
        val logradouro: String,
        val compemento: String,
        val bairro: String,
        val localidade: String,
        @SerializedName ("uf") val estado: String


)


