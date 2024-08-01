package com.fiap.fastfood.fastfood.adapter.input.rest.response

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

data class ClienteResponse (
    val cpf: String?,
    val nome: String?,
    val email: String?
)

fun Cliente.toResponse(): ClienteResponse =
    with(this){
        return ClienteResponse(
            cpf=this.cpf,
            nome=this.nome,
            email=this.email
        )
    }