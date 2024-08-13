package com.fiap.fastfood.fastfood.application.ports.service.item

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.model.Item

interface CadastrarItemUseCase {
    fun execute(item: ItemRequest): Item
}