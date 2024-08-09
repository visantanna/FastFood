package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toResponse
import com.fiap.fastfood.fastfood.adapter.input.rest.request.PedidoRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.PedidoResponse
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiPedidos
import com.fiap.fastfood.fastfood.application.ports.service.pedido.CheckoutUseCase
import com.fiap.fastfood.fastfood.application.ports.service.pedido.ObterTodosPedidosUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/pedidos")
class ControllerPedidos(
    val obterTodosPedidosUseCase: ObterTodosPedidosUseCase,
    val checkoutUseCase: CheckoutUseCase
): ApiPedidos {
    @PostMapping
    override fun finalizacaoPedido(@RequestBody pedido: PedidoRequest): ResponseEntity<PedidoResponse> {
        return ResponseEntity.ok(checkoutUseCase.execute(pedido).toResponse())
    }

    @GetMapping
    override fun obterPedidos(): ResponseEntity<List<PedidoResponse>> {
        val pedidos = obterTodosPedidosUseCase.execute()
        return ResponseEntity.ok(pedidos.map {it.toResponse()})
    }
}