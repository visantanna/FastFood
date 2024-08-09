package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toResponse
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ClienteRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.ClienteResponse
import com.fiap.fastfood.fastfood.application.domain.usecases.cliente.ObterClienteByCpfUseCaseImpl
import com.fiap.fastfood.fastfood.application.ports.service.cliente.CriarClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.service.cliente.ObterClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiCliente
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/clientes")
class ControllerCliente(
    val criarClienteUseCase: CriarClienteUseCase,
    val obterClienteByCpfUseCase: ObterClienteByCpfUseCaseImpl
) : ApiCliente {
    @PostMapping
    override fun cadastroCliente(@RequestBody cliente: ClienteRequest): ResponseEntity<ClienteResponse> {
        return ResponseEntity.ok(criarClienteUseCase.execute(cliente).toResponse());
    }

    @GetMapping("/{cpf}")
    override fun obterCliente(@PathVariable cpf: String): ResponseEntity<ClienteResponse> {
        val cliente = obterClienteByCpfUseCase.execute(cpf)
        return ResponseEntity.ok(cliente.toResponse())


    }

}