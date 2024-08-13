package com.fiap.fastfood.fastfood.application.ports.service.pedido

import com.fiap.fastfood.fastfood.adapter.input.rest.request.PedidoRequest
import com.fiap.fastfood.fastfood.application.domain.model.Pedido

interface CheckoutUseCase {
    fun execute(pedidoRequest: PedidoRequest): Pedido
}