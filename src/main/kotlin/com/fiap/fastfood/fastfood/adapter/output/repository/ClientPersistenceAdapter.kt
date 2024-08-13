package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.output.repository.repo.ClientRepository
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.ports.output.repository.ClientePortRepository
import org.springframework.stereotype.Service

@Service
class ClientPersistenceAdapter(
    private val clienteRepository: ClientRepository
) : ClientePortRepository{


    override fun save(cliente: Cliente):Cliente {
        val clienteEntity = cliente.toEntity()
        return clienteRepository.save(clienteEntity).toDomain()
    }

    override fun obterClientePorCpf(cpf: String): Cliente? {
        return clienteRepository.findByCpf(cpf)?.toDomain();
    }

    override fun exist(id: String): Boolean {
        return clienteRepository.existsById(id)
    }

    override fun existPorCpf(cpf: String): Boolean {
        return clienteRepository.existsByCpf(cpf)
    }

    override fun obterClientePorId(id: String): Cliente {
        return clienteRepository.findById(id).get().toDomain()
    }

}