package com.fiap.fastfood.fastfood.application.ports.service.cliente

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ClienteRequest
import com.fiap.fastfood.fastfood.application.domain.model.Cliente

interface CriarClienteUseCase {
    fun execute(cliente: ClienteRequest):Cliente

}