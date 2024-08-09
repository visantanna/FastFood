package com.fiap.fastfood.fastfood.application.ports.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ClienteRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.ClienteResponse
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import org.springframework.http.ResponseEntity


interface ApiCliente {
    fun cadastroCliente( cliente: ClienteRequest): ResponseEntity<ClienteResponse>
    fun obterCliente(cpf:String): ResponseEntity<ClienteResponse>
}