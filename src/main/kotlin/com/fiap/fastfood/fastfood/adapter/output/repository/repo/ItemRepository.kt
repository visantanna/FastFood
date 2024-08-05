package com.fiap.fastfood.fastfood.adapter.output.repository.repo

import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ClienteEntity
import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ItemEntity
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository: MongoRepository<ItemEntity, String> {
    fun findByCategoria(categoria: String) : List<ItemEntity>
}