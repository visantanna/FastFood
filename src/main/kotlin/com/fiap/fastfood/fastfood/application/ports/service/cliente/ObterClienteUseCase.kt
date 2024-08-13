package com.fiap.fastfood.fastfood.application.ports.service.cliente

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

interface ObterClienteUseCase {
    fun execute(identificador:String): Cliente
}