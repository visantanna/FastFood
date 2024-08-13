package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.output.repository.repo.PedidoRepository
import com.fiap.fastfood.fastfood.application.domain.model.Pedido
import com.fiap.fastfood.fastfood.application.ports.output.repository.PedidoPortRepository
import org.springframework.stereotype.Service

@Service
class PedidoPersistenceAdapter(
    val pedidoRepository: PedidoRepository
): PedidoPortRepository {
    override fun savePedido(pedido: Pedido): Pedido {
        return pedidoRepository.save(pedido.toEntity()).toDomain()
    }

    override fun getAllPedidos(): List<Pedido> {
        return pedidoRepository.findAll().map { it.toDomain() }
    }
}