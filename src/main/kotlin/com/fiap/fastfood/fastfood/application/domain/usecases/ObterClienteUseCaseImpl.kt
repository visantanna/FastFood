package com.fiap.fastfood.fastfood.application.domain.usecases

import com.fiap.fastfood.fastfood.adapter.output.repository.ClientPersistenceAdapter
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.ObterClienteUseCase
import org.springframework.stereotype.Service

@Service
class ObterClienteUseCaseImpl(
    val clienteRepository: ClientPersistenceAdapter
): ObterClienteUseCase {
    override fun execute(cpf: String): Cliente? {
        return clienteRepository.obterCliente(cpf)
    }
}