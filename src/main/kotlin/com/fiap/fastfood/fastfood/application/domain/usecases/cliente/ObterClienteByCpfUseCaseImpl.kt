package com.fiap.fastfood.fastfood.application.domain.usecases.cliente

import com.fiap.fastfood.fastfood.adapter.output.repository.ClientPersistenceAdapter
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.service.cliente.ObterClienteUseCase
import org.springframework.stereotype.Service

@Service
class ObterClienteByCpfUseCaseImpl(
    val clienteRepository: ClientPersistenceAdapter
): ObterClienteUseCase {
    override fun execute(identificador: String): Cliente {
        val cpf = identificador
        if(!clienteRepository.existPorCpf(cpf))
            throw BussinessLogicException("Cliente com CPF: $cpf não foi encontrado", 404)
        return clienteRepository.obterClientePorCpf(identificador)!!
    }
}