package com.fiap.fastfood.fastfood.application.domain.usecases.pedido

import com.fiap.fastfood.fastfood.application.domain.model.Pedido
import com.fiap.fastfood.fastfood.application.ports.output.repository.PedidoPortRepository
import com.fiap.fastfood.fastfood.application.ports.service.pedido.ObterTodosPedidosUseCase
import org.springframework.stereotype.Service

@Service
class ObterTodosPedidosUseCaseImpl(
    val pedidoPortRepository: PedidoPortRepository
): ObterTodosPedidosUseCase {
    override fun execute(): List<Pedido> {
        return pedidoPortRepository.getAllPedidos()
    }
}