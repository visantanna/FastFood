package com.fiap.fastfood.fastfood.domain.ports.input

import com.fiap.fastfood.fastfood.domain.model.Cliente


interface ApiCliente {
    fun cadastroCliente( cliente: Cliente);
    fun obterCliente(cpf:String);
}