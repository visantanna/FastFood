package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiPedidos
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/pedidos")
class ControllerPedidos: ApiPedidos {
    @PostMapping
    override fun finalizacaoPedido(@RequestBody userCpf: String, @RequestBody idItems: List<String>) {
        TODO("Not yet implemented")
    }

    @GetMapping
    override fun obterPedidos() {
        TODO("Not yet implemented")
    }
}