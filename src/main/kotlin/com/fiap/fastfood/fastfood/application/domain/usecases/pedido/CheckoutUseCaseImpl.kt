package com.fiap.fastfood.fastfood.application.domain.usecases.pedido

import com.fiap.fastfood.fastfood.adapter.input.rest.request.PedidoRequest
import com.fiap.fastfood.fastfood.application.domain.model.Pedido
import com.fiap.fastfood.fastfood.application.domain.usecases.cliente.ObterClienteByIdUseCaseImpl
import com.fiap.fastfood.fastfood.application.domain.validation.PedidoValidador
import com.fiap.fastfood.fastfood.application.ports.service.pedido.CheckoutUseCase
import com.fiap.fastfood.fastfood.application.ports.service.item.ObterItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.PedidoPortRepository
import org.springframework.stereotype.Service

@Service
class CheckoutUseCaseImpl(
    val pedidoPort: PedidoPortRepository,
    val pedidoValidador: PedidoValidador,
    val obterItemUseCase: ObterItemUseCase,
    val obterClienteByIdUseCaseImpl: ObterClienteByIdUseCaseImpl
): CheckoutUseCase {
    override fun execute(pedidoRequest: PedidoRequest): Pedido {
        pedidoValidador.validatePedido(pedidoRequest)
        val pedido = Pedido(
            null,
            obterClienteByIdUseCaseImpl.execute(pedidoRequest.clienteId),
            pedidoRequest.lanche?.let { obterItemUseCase.execute(it) },
            pedidoRequest.acompanhamento?.let { obterItemUseCase.execute(it) },
            pedidoRequest.bebida?.let { obterItemUseCase.execute(it) },
            pedidoRequest.sobremesa?.let { obterItemUseCase.execute(it) }
        )
        return pedidoPort.savePedido(pedido)
    }
}