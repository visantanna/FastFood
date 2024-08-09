package com.fiap.fastfood.fastfood.application.domain.usecases.cliente

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toDomain
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ClienteRequest
import com.fiap.fastfood.fastfood.adapter.output.repository.ClientPersistenceAdapter
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.service.cliente.CriarClienteUseCase
import org.springframework.stereotype.Service

@Service
class CriarClienteUseCaseImpl(
    val clientePersistence: ClientPersistenceAdapter
): CriarClienteUseCase {
    @Throws(BussinessLogicException::class)
    override fun execute(cliente: ClienteRequest):Cliente {
        val novoCliente:Cliente = cliente.toDomain()
        //TODO validação por email?
        if(novoCliente.cpf != null){
            if (clientePersistence.existPorCpf(novoCliente.cpf))
                throw BussinessLogicException("Cliente já cadastrado!", 409)
        }
        return clientePersistence.save(novoCliente)
    }
}