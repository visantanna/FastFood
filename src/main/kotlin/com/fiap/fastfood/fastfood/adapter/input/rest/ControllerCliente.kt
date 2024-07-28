package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.domain.model.Cliente
import com.fiap.fastfood.fastfood.domain.ports.input.ApiCliente
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/clientes")
class ControllerCliente : ApiCliente{
    @PostMapping
    override fun cadastroCliente(@RequestBody cliente: Cliente) {
        TODO("Not yet implemented")
    }

    @GetMapping("/{id}")
    override fun obterCliente(@PathVariable cpf: String) {
        TODO("Not yet implemented")
    }

}