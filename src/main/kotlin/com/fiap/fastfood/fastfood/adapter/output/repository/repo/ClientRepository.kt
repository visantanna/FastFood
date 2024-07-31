package com.fiap.fastfood.fastfood.adapter.output.repository.repo

import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ClienteEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: MongoRepository<ClienteEntity, String> {
    fun findByCpf(): ClienteEntity?
}