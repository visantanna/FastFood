package com.fiap.fastfood.fastfood.application.ports.output.repository

import com.fiap.fastfood.fastfood.application.domain.model.Cliente

interface ClientePortRepository {
    fun save(cliente: Cliente): Cliente
    fun obterClientePorCpf(cpf: String): Cliente?
    fun exist(id: String): Boolean
    fun existPorCpf(cpf: String): Boolean
    fun obterClientePorId(id: String): Cliente
}