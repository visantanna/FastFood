package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.validation.ItemValidador
import com.fiap.fastfood.fastfood.application.ports.service.item.ObterItemPorCategoriaUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class ObterPorCategoriaUseCaseImpl(
    val itemPortRepository: ItemPortRepository,
    val itemValidador: ItemValidador
): ObterItemPorCategoriaUseCase {
    override fun execute(categoria: String): List<Item> {
        itemValidador.validateCategory(categoria)
        return itemPortRepository.getByCategory(Categoria.valueOf(categoria))
    }
}