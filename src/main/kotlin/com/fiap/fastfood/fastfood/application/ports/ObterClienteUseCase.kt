package com.fiap.fastfood.fastfood.application.ports

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

interface ObterClienteUseCase {
    fun execute(cpf:String): Cliente?
}