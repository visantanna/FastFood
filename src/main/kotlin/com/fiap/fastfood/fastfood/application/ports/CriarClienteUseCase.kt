package com.fiap.fastfood.fastfood.application.ports

import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import org.springframework.stereotype.Service

@Service
interface CriarClienteUseCase {
    fun execute(cliente: Cliente);

}