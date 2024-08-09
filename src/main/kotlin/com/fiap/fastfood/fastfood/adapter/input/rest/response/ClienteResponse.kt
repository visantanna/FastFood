package com.fiap.fastfood.fastfood.adapter.input.rest.response

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

data class ClienteResponse (
    val id: String,
    val cpf: String?,
    val nome: String?,
    val email: String?
)

