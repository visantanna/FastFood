package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.CriarClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.ObterClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiCliente
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.net.http.HttpResponse

@RestController
@RequestMapping("/v1/clientes")
class ControllerCliente(
    val criarClienteUseCase: CriarClienteUseCase,
    val ObterClienteUseCase: ObterClienteUseCase
) : ApiCliente {
    @PostMapping
    override fun cadastroCliente(@RequestBody cliente: Cliente) {
        criarClienteUseCase.execute(cliente)
    }

    @GetMapping("/{id}")
    override fun obterCliente(@PathVariable cpf: String) {
        ObterClienteUseCase.execute(cpf)?.toResponse() ?: HttpResponse(body="Cliente não encontrado",status= HttpStatus.NOT_FOUND)
    }

}