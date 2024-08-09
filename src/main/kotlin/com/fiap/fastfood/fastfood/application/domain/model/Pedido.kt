package com.fiap.fastfood.fastfood.application.domain.model

import org.apache.catalina.User

data class Pedido(
    val id: String?,
    val cliente: Cliente,
    val lanche: Item?,
    val acompanhamento: Item?,
    val bebida: Item?,
    val sobremesa: Item?
)