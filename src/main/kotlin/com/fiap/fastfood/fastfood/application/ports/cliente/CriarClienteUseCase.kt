package com.fiap.fastfood.fastfood.application.ports.cliente

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

interface CriarClienteUseCase {
    fun execute(cliente: Cliente):Cliente

}