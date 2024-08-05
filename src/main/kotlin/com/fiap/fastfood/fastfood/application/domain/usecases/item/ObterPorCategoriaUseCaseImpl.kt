package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.validation.ItemValidator
import com.fiap.fastfood.fastfood.application.ports.item.ObterItemPorCategoriaUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository

class ObterPorCategoriaUseCaseImpl(
    val itemPortRepository: ItemPortRepository,
    val itemValidator: ItemValidator
): ObterItemPorCategoriaUseCase {
    override fun execute(categoria: String): List<Item> {
        itemValidator.validateCategory(categoria)
        return itemPortRepository.getByCategory(Categoria.valueOf(categoria))
    }
}