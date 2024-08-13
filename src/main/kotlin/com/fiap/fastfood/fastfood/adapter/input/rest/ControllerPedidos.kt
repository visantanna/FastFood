package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toResponse
import com.fiap.fastfood.fastfood.adapter.input.rest.request.PedidoRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.PedidoResponse
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiPedidos
import com.fiap.fastfood.fastfood.application.ports.service.pedido.CheckoutUseCase
import com.fiap.fastfood.fastfood.application.ports.service.pedido.ObterTodosPedidosUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/pedidos")
class ControllerPedidos(
    val obterTodosPedidosUseCase: ObterTodosPedidosUseCase,
    val checkoutUseCase: CheckoutUseCase
): ApiPedidos {
    @Operation(summary = "Cria um pedido com lanche, sobremesa, acompanhamento e bebida, com status Recebido e vincula com um cliente por ID." +
            " Nenhum dos items é obrigatório, porém caso não tenha nenhum item no pedido a api retorna 400. Também valida a " +
            "existência de itens e clientes, caso não encontre no banco retorna 400")
    @ApiResponses(value = [
        ApiResponse(responseCode = "400", description = "Pedido deve ter pelo menos um item!" ,content = [Content()]),
        ApiResponse(responseCode = "400", description = "Não existe cliente enviado no pedido. Id do cliente: {id}" ,content = [Content()]),
        ApiResponse(responseCode = "400", description = "Não existe Item da categoria: {categoria} com o id: {itemId} cadastrado" ,content = [Content()])
    ])
    @PostMapping
    override fun finalizacaoPedido(@RequestBody pedido: PedidoRequest): ResponseEntity<PedidoResponse> {
        return ResponseEntity.ok(checkoutUseCase.execute(pedido).toResponse())
    }

    @Operation(summary = "Retorna todos os pedidos cadastrados")
    @GetMapping
    override fun obterPedidos(): ResponseEntity<List<PedidoResponse>> {
        val pedidos = obterTodosPedidosUseCase.execute()
        return ResponseEntity.ok(pedidos.map {it.toResponse()})
    }
}