package com.fiap.fastfood.fastfood.adapter.input.rest.request

data class PedidoRequest(
    val clienteId: String,
    val lanche:String?,
    val acompanhamento: String?,
    val bebida: String?,
    val sobremesa: String?
)
