package com.fiap.fastfood.fastfood.application.ports.output.repository

import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Item

interface ItemPortRepository {
    fun save(item: Item): Item
    fun getByCategory(category: Categoria): List<Item>
    fun delete(id: String)
    fun alter(id: String , item:Item): Item
    fun exists(id: String): Boolean
}