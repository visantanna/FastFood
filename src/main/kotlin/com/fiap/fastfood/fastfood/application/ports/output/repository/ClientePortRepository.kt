package com.fiap.fastfood.fastfood.application.ports.output.repository

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

interface ClientePortRepository {
    fun save(cliente: Cliente): Cliente
    fun obterCliente(cpf: String): Cliente?
}