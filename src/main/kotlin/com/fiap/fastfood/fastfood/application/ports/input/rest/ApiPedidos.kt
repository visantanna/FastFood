package com.fiap.fastfood.fastfood.application.ports.input.rest

interface ApiPedidos {
    fun finalizacaoPedido(userCpf:String, idItems: List<String> )
    fun obterPedidos()
}