package com.fiap.fastfood.fastfood.adapter.input.rest.response

import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.domain.model.PedidoStatus

data class PedidoResponse(
    val id: String,
    val cliente: Cliente,
    val lanche: ItemResponse?,
    val acompanhamento: ItemResponse?,
    val bebida: ItemResponse?,
    val sobremesa: ItemResponse?,
    val status: String
)