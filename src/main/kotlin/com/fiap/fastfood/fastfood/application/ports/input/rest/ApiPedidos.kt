package com.fiap.fastfood.fastfood.application.ports.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.request.PedidoRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.PedidoResponse
import org.springframework.http.ResponseEntity

interface ApiPedidos {
    fun finalizacaoPedido(pedido: PedidoRequest ): ResponseEntity<PedidoResponse>
    fun obterPedidos(): ResponseEntity<List<PedidoResponse>>
}