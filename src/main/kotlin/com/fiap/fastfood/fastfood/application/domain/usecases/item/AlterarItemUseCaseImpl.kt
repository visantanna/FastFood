package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toDomain
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.validation.ItemValidator
import com.fiap.fastfood.fastfood.application.ports.item.AlterarItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class AlterarItemUseCaseImpl(
    val itemValidator: ItemValidator,
    val itemPortRepository: ItemPortRepository
) : AlterarItemUseCase{
    override fun execute(id: String, item: ItemRequest): Item {
        itemValidator.validate(item)
        val itemDomain = item.toDomain()
        if(itemPortRepository.exists(id))
            return itemPortRepository.alter(id, itemDomain)
        throw BussinessLogicException("Item a ser alterado não existe!", 404)
    }
}