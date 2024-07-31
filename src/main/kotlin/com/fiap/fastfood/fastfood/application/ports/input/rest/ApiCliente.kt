package com.fiap.fastfood.fastfood.application.ports.input.rest

import com.fiap.fastfood.fastfood.application.domain.model.Cliente


interface ApiCliente {
    fun cadastroCliente( cliente: Cliente);
    fun obterCliente(cpf:String);
}