package com.fiap.fastfood.fastfood.adapter.output.repository.repo

import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ItemEntity
import com.fiap.fastfood.fastfood.adapter.output.repository.entities.PedidoEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository : MongoRepository<PedidoEntity, String> {
}