package com.fiap.fastfood.fastfood.application.ports.service.item

import com.fiap.fastfood.fastfood.application.domain.model.Item

interface ObterItemUseCase {
    fun execute(id: String): Item
}