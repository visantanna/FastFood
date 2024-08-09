package com.fiap.fastfood.fastfood.application.ports.output.repository

import com.fiap.fastfood.fastfood.application.domain.model.Pedido

interface PedidoPortRepository {
    fun savePedido(pedido:Pedido):Pedido
    fun getAllPedidos(): List<Pedido>
}