package com.fiap.fastfood.fastfood.application.domain.usecases

import com.fiap.fastfood.fastfood.adapter.output.repository.ClientPersistenceAdapter
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.CriarClienteUseCase

class CriarClienteUseCaseImpl(
    val clientePersistence: ClientPersistenceAdapter
): CriarClienteUseCase {
    @Throws(BussinessLogicException::class)
    override fun execute(cliente: Cliente) {
        val oldCliente:Cliente?
        if(cliente.cpf != null){
            oldCliente= clientePersistence.obterCliente(cliente.cpf)
            if (oldCliente == null)
                throw BussinessLogicException("Cliente já cadastrado!", 400)
        }else {
            return clientePersistence.save(cliente)
        }

    }

}