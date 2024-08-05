package com.fiap.fastfood.fastfood.application.domain.usecases.cliente

import com.fiap.fastfood.fastfood.adapter.output.repository.ClientPersistenceAdapter
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.cliente.CriarClienteUseCase
import org.springframework.stereotype.Service

@Service
class CriarClienteUseCaseImpl(
    val clientePersistence: ClientPersistenceAdapter
): CriarClienteUseCase {
    @Throws(BussinessLogicException::class)
    override fun execute(cliente: Cliente):Cliente {
        val oldCliente:Cliente?
        //TODO validação por email?
        if(cliente.cpf != null){
            oldCliente= clientePersistence.obterCliente(cliente.cpf)
            if (oldCliente != null)
                throw BussinessLogicException("Cliente já cadastrado!", 409)
        }
        return clientePersistence.save(cliente)
    }

}