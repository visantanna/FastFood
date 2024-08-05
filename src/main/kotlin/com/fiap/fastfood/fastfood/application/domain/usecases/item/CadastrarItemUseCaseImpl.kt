package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toDomain
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.adapter.output.repository.repo.ClientRepository
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.validation.ItemValidator
import com.fiap.fastfood.fastfood.application.ports.item.CadastrarItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class CadastrarItemUseCaseImpl(
    val itemValidator: ItemValidator,
    val itemRepository: ItemPortRepository
): CadastrarItemUseCase {
    override fun execute(item: ItemRequest): Item {
        itemValidator.validate(item);
        val itemDomain:Item = item.toDomain()
        return itemRepository.save(itemDomain)
    }

}
