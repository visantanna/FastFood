package com.fiap.fastfood.fastfood.application.ports.service.item

import com.fiap.fastfood.fastfood.application.domain.model.Item

interface ObterItemPorCategoriaUseCase {
    fun execute(categoria: String): List<Item>
}