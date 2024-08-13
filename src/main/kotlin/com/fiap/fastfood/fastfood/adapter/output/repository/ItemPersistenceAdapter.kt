package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ItemEntity
import com.fiap.fastfood.fastfood.adapter.output.repository.repo.ItemRepository
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class ItemPersistenceAdapter(
    val itemRepository: ItemRepository
): ItemPortRepository {
    override fun save(item: Item): Item {
        val itemEntity = item.toEntity()
        return itemRepository.save(itemEntity).toDomain()
    }

    override fun getByCategory(category: Categoria): List<Item> {
        return itemRepository.findByCategoria(category.name).map { it.toDomain() }
    }

    override fun delete(id: String) {
        val item = itemRepository.findById(id).get()
        itemRepository.delete(item)
    }

    override fun alter(id:String, item: Item): Item {
        val itemEntity = item.toEntity()
        itemEntity.id = id
        return itemRepository.save(itemEntity).toDomain()
    }

    override fun exists(id: String): Boolean {
        return itemRepository.existsById(id);
    }

    override fun getById(id: String): Item {
        return itemRepository.findById(id).get().toDomain()
    }




}