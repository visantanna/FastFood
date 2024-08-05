package com.fiap.fastfood.fastfood.application.ports.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.model.Item
import org.springframework.http.ResponseEntity

interface ApiItem {
    fun cadastraItem(item: ItemRequest): ResponseEntity<Item>
    fun alteraItem(id: String, item: ItemRequest): ResponseEntity<Item>
    fun removeItem(id: String): ResponseEntity<Item>
    fun obterItemsPorCategoria(categoria:String): ResponseEntity<List<Item>>
}