package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.response.ClienteResponse
import com.fiap.fastfood.fastfood.adapter.input.rest.response.toResponse
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.CriarClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.ObterClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiCliente
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/clientes")
class ControllerCliente(
    val criarClienteUseCase: CriarClienteUseCase,
    val obterClienteUseCase: ObterClienteUseCase
) : ApiCliente {
    @PostMapping
    override fun cadastroCliente(@RequestBody cliente: Cliente): ResponseEntity<ClienteResponse> {
        return ResponseEntity.ok(criarClienteUseCase.execute(cliente).toResponse());
    }

    @GetMapping("/{cpf}")
    override fun obterCliente(@PathVariable cpf: String): ResponseEntity<ClienteResponse> {
        val cliente = obterClienteUseCase.execute(cpf)
        if(cliente != null)
            return ResponseEntity.ok(cliente.toResponse())
        else
            return ResponseEntity<ClienteResponse>(HttpStatus.NOT_FOUND)

    }

}