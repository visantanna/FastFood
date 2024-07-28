package com.fiap.fastfood.fastfood.domain.ports.input

interface ApiPedidos {
    fun finalizacaoPedido(userCpf:String, idItems: List<String> )
    fun obterPedidos()
}