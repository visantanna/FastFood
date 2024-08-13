package com.fiap.fastfood.fastfood.application.ports.service.item

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.model.Item

interface AlterarItemUseCase {
    fun execute(id: String , item: ItemRequest): Item
}