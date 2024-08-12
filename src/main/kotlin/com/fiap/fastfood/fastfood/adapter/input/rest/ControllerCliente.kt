package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toResponse
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ClienteRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.ClienteResponse
import com.fiap.fastfood.fastfood.application.domain.usecases.cliente.ObterClienteByCpfUseCaseImpl
import com.fiap.fastfood.fastfood.application.ports.service.cliente.CriarClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.service.cliente.ObterClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiCliente
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/clientes")
class ControllerCliente(
    val criarClienteUseCase: CriarClienteUseCase,
    val obterClienteByCpfUseCase: ObterClienteByCpfUseCaseImpl
) : ApiCliente {
    @Operation(summary = "Cadastra cliente, unica validação é se o cpf  já existe, caso exista o retorno é 409. " +
            "É possivel gerar Cliente sem nenhum atributo, nesse caso o cliente vai ser referenciado pelo id e " +
            "ele não será encontrado na busca por cpf")
    @ApiResponses(value = [
        ApiResponse(responseCode = "409", description = "Cliente já cadastrado!" ,content = [Content()])
    ])
    @PostMapping
    override fun cadastroCliente(@RequestBody cliente: ClienteRequest): ResponseEntity<ClienteResponse> {
        return ResponseEntity.ok(criarClienteUseCase.execute(cliente).toResponse());
    }

    @Operation(summary = "Retorna o cliente cadastrado com o cpf enviado")
    @ApiResponses(value = [
        ApiResponse(responseCode = "404", description = "Cliente com CPF: {cpf} não foi encontrado" ,content = [Content()])
    ])
    @GetMapping("/{cpf}")
    override fun obterCliente(@PathVariable cpf: String): ResponseEntity<ClienteResponse> {
        val cliente = obterClienteByCpfUseCase.execute(cpf)
        return ResponseEntity.ok(cliente.toResponse())


    }

}