package com.fiap.fastfood.fastfood.application.domain.usecases.cliente

import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.service.cliente.ObterClienteUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ClientePortRepository
import org.springframework.stereotype.Service

@Service
class ObterClienteByIdUseCaseImpl(
    val clientePortRepository: ClientePortRepository
): ObterClienteUseCase {
    override fun execute(identificador: String): Cliente {
        val clienteId = identificador
        if(!clientePortRepository.exist(clienteId))
            throw BussinessLogicException("Cliente com o id $clienteId não encontrado!", 404)
        return clientePortRepository.obterClientePorId(clienteId)
    }
}