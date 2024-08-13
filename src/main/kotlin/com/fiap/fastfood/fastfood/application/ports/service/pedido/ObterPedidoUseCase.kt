package com.fiap.fastfood.fastfood.application.ports.service.pedido

import com.fiap.fastfood.fastfood.application.domain.model.Pedido

interface ObterTodosPedidosUseCase {
    fun execute():List<Pedido>
}