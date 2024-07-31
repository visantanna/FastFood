package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.output.repository.repo.ClientRepository
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.output.repository.ClientePortRepository
import org.springframework.stereotype.Service

@Service
class ClientPersistenceAdapter(
    private val clienteRepository: ClientRepository
) : ClientePortRepository{


    override fun save(cliente: Cliente) {
        val clienteEntity = cliente.toEntity()
        clienteRepository.save(clienteEntity)
    }

    override fun obterCliente(cpf: String): Cliente? {
        return clienteRepository.findByCpf()?.toDomain();
    }

}